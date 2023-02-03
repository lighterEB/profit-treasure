const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})

module.exports = {
  devServer: {
    open:true,
    host:'localhost',
    port: 8082,
    //配置跨域
    proxy: {
      '/': {
        target: "http://127.0.0.1:8080/",
        changeOrigin:true,
        secure:true,
      }
    }
  }
}
