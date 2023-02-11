const { defineConfig } = require('@vue/cli-service')
const { VantResolver } = require("unplugin-vue-components/resolvers");
const ComponentsPlugin = require("unplugin-vue-components/webpack");
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
      '/myApi': {
        target: "http://127.0.0.1:8083/",
        changeOrigin:true,
        secure:false,
        pathRewrite: {
          '^/myApi': ''
        }
      }
    }
  },
  configureWebpack: {
    plugins: [
      ComponentsPlugin({
        resolvers: [VantResolver()],
      }),
    ],
  },
  lintOnSave: false
}
