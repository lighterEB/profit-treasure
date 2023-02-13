import axios from "axios";

var instance = axios.create({
    baseURL: "/myApi"
})

// 响应拦截器
instance.interceptors.response.use(function (response) {

    var status = response.status;

    switch (status) {
        case 200:
            return response
        case 401:
            alert("未授权")
            return
        case 500:
            alert("出现异常")
            return
        default:
            alert("系统异常")
            return
    }
},(error)=>{
    return Promise.reject(error);
})

export function myajax(resconf){
    return instance(resconf)
}