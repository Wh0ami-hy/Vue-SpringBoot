import request from '@/utils/request'

export function parseQuestion(data) {
  return request({
    url: '/question/analyze',
    method: 'post',
    data
  })
}

export function importQuestion(data) {
  return request({
    url: '/vue-admin-template/user/info',
    method: 'post',
    data
  })
}