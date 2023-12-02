package com.yatong.exam.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;




@Tag(name = "题目管理")
@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionServiceImpl questionService;
    @Autowired
    CourseClient courseClient;

    @Operation(summary = "批量创建题目")
    @PostMapping("/batchAdd")
    public Result batchAdd(@RequestBody @Validated BatchQuestion batchQuestion){
        Courses course = courseClient.findCourse(batchQuestion.getCourseId());
        Integer userId = UserAuthUtil.getUserId();
        if(course==null||course.getUserId()!=userId){
            return Result.failed(ResultCode.PARAM_ERROR);
        }
        List<QuestionInfoVo> list=batchQuestion.getQuestionInfos();
        List<String> result=new ArrayList<>();
        list.stream().forEach(i->{
            i.setTeacherId(userId);
            i.setTagId(batchQuestion.getTagId());
            i.setCourseId(batchQuestion.getCourseId());
            result.add( questionService.addQuestion(i));
        });
        return Result.success(result);
    }
    @Operation(summary = "获取匹配题目规则")
    @GetMapping("/rules")
    public Result rules(){
        Map<String, String> collect = Arrays.stream(DefaultQuestionRuleEnum.values()).collect(Collectors.toMap(DefaultQuestionRuleEnum::name, DefaultQuestionRuleEnum::getName));
        return Result.success(collect);
    }
    @Operation(summary = "解析题目文本")
    @PostMapping("/analyze")
    public Result analyze(@RequestBody @Validated ParseQuestionVo parseQuestionVo){
        // TODO:还是后端呢？
        ParseQuestionRules rule= DefaultQuestionRuleEnum.CHAOXING.getRule();
        if(parseQuestionVo.getCustomRule()!=null){
            rule= parseQuestionVo.getCustomRule();
        }else if(parseQuestionVo.getDefaultRule()!=null){
            rule = parseQuestionVo.getDefaultRule().getRule();
        }
        //将富文本换行改成\n
        String text= parseQuestionVo.getQuestionsText().replaceAll("<br\\/?>","\n");
        //去除富文本最外层p
        text=text.replaceAll("<p>|<\\/p>","");
        return Result.success( ParseQuestionText.parse(text,rule));
    }

    @Operation(summary = "更新题目")
    @PostMapping("/update")
    public Result update(@RequestBody Question question){
        //判断题目是不是自己的
        Question qu = questionService.getById(question.getId());
        Integer userId = UserAuthUtil.getUserId();
        if(qu==null||qu.getTeacherId()!=userId){
            return Result.failed(ResultCode.PARAM_ERROR);
        }
        question.setCourseId(null);
        question.setTeacherId(null);
        questionService.updateById(question);
        return Result.msgSuccess("更新成功");
    }
    @Operation(summary = "删除题目")
    @PostMapping("/delete/{questionId}")
    public Result delete(@PathVariable String questionId){
        //判断题目是不是自己的
        Question qu = questionService.getById(questionId);
        Integer userId = UserAuthUtil.getUserId();
        if(qu==null||qu.getTeacherId()!=userId){
            return Result.failed(ResultCode.PARAM_ERROR);
        }
        questionService.removeById(questionId);
        return Result.msgSuccess("删除成功");
    }
    @Operation(summary = "题目列表")
    @GetMapping("/list/{courseId}")
    public Result list(
            @PathVariable Integer courseId,
            @RequestParam Integer currentPage,
            @RequestParam(required = false) Integer tagId){
        Courses course = courseClient.findCourse(courseId);
        Integer userId = UserAuthUtil.getUserId();
        if(course==null){
            return Result.failed(ResultCode.PARAM_ERROR);
        }
        // 不需要查分组是不是自己的，因为，下面查询时课程id 和分组id 同时成立才行
        LambdaQueryWrapper<Question> queryWrapper=new LambdaQueryWrapper<>();
        //老师
        Map<SFunction<Question, ?>, Object> queryMap=new HashMap<>();
        queryMap.put(Question::getTagId,tagId);
        queryMap.put(Question::getCourseId,courseId);
        if(course.getUserId()!=userId){
            //1.判断是否课程班级中
            JoinClass joinClass = courseClient.joinCourseByStuId(courseId, userId);
            if(joinClass==null){
                return Result.failed(ResultCode.PARAM_ERROR);
            }
            //TODO:判断该班级是否在考试，如果考试禁止获取
            //2.查找有公开题目的分类
            queryWrapper.gt(Question::getIsPublic,0);
        }
        queryWrapper.allEq(queryMap).orderByDesc(Question::getCreatedAt);
        IPage<Question> page=new Page<>(currentPage,10);
        IPage<Question> list = questionService.page(page,queryWrapper);
        return Result.success(PageResult.setResult(list));
    }
}
