package com.yatong.exam.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.yatong.exam.constant.enums.QuestionRuleEnum;
import com.yatong.exam.model.entity.ParseQuestionRules;
import com.yatong.exam.model.vo.BatchQuestionVo;
import com.yatong.exam.model.vo.ParseQuestionVo;
import com.yatong.exam.service.Impl.QuestionServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.yatong.exam.utils.Result;
import com.yatong.exam.constant.enums.ResultCode;

import java.sql.SQLException;


/**
 * @Author HouYi
 * @Date 2023/12/9 14:27
 * @Description 题库功能：题目批量预览、批量导入、批量删除、批量查看、题目修改，支持单选、多选、填空、判断、主观
 * @Since version-1.0
 */

@Slf4j
@Tag(name = "题目管理")
@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionServiceImpl questionService;

    @Operation(summary = "批量创建题目")
    @SaCheckPermission("user-add")
    @PostMapping("/batchAdd")
    public Result batchAdd(@RequestBody @Validated BatchQuestionVo batchQuestionVo) throws SQLException {

        questionService.batchAddQuestion(batchQuestionVo);
        return new Result(ResultCode.SUCCESS, null);
    }

    @Operation(summary = "解析题目文本")
    @SaCheckPermission("user-add")
    @PostMapping("/analyze")
    public Result analyze(@RequestBody @Validated ParseQuestionVo parseQuestionVo){

        ParseQuestionRules rule= QuestionRuleEnum.CHAOXING.getRule();

        // 接受的text 应该是标准的富文本转的html文本

        //将富文本换行改成\n
        String text= parseQuestionVo.getQuestionsText().replaceAll("<br\\/?>","\n");
        //去除富文本最外层p
        text=text.replaceAll("<p>|<\\/p>","");

        return new Result(ResultCode.SUCCESS, questionService.parseQuestionText(text,rule));
    }

//    @Operation(summary = "更新题目")
//    @PostMapping("/update")
//    public Result update(@RequestBody Question question){
//        //判断题目是不是自己的
//        Question qu = questionService.getById(question.getId());
//        Integer userId = UserAuthUtil.getUserId();
//        if(qu==null||qu.getTeacherId()!=userId){
//            return Result.failed(ResultCode.PARAM_ERROR);
//        }
//        question.setCourseId(null);
//        question.setTeacherId(null);
//        questionService.updateById(question);
//        return Result.msgSuccess("更新成功");
//    }
//    @Operation(summary = "删除题目")
//    @PostMapping("/delete/{questionId}")
//    public Result delete(@PathVariable String questionId){
//        //判断题目是不是自己的
//        Question qu = questionService.getById(questionId);
//        Integer userId = UserAuthUtil.getUserId();
//        if(qu==null||qu.getTeacherId()!=userId){
//            return Result.failed(ResultCode.PARAM_ERROR);
//        }
//        questionService.removeById(questionId);
//        return Result.msgSuccess("删除成功");
//    }
//    @Operation(summary = "题目列表")
//    @GetMapping("/list/{courseId}")
//    public Result list(
//            @PathVariable Integer courseId,
//            @RequestParam Integer currentPage,
//            @RequestParam(required = false) Integer tagId){
//        Courses course = courseClient.findCourse(courseId);
//        Integer userId = UserAuthUtil.getUserId();
//        if(course==null){
//            return Result.failed(ResultCode.PARAM_ERROR);
//        }
//        // 不需要查分组是不是自己的，因为，下面查询时课程id 和分组id 同时成立才行
//        LambdaQueryWrapper<Question> queryWrapper=new LambdaQueryWrapper<>();
//        //老师
//        Map<SFunction<Question, ?>, Object> queryMap=new HashMap<>();
//        queryMap.put(Question::getTagId,tagId);
//        queryMap.put(Question::getCourseId,courseId);
//        if(course.getUserId()!=userId){
//            //1.判断是否课程班级中
//            JoinClass joinClass = courseClient.joinCourseByStuId(courseId, userId);
//            if(joinClass==null){
//                return Result.failed(ResultCode.PARAM_ERROR);
//            }
//            //TODO:判断该班级是否在考试，如果考试禁止获取
//            //2.查找有公开题目的分类
//            queryWrapper.gt(Question::getIsPublic,0);
//        }
//        queryWrapper.allEq(queryMap).orderByDesc(Question::getCreatedAt);
//        IPage<Question> page=new Page<>(currentPage,10);
//        IPage<Question> list = questionService.page(page,queryWrapper);
//        return Result.success(PageResult.setResult(list));
//    }
}
