const path = require('path');
const webpack = require("webpack");

module.exports = {
    //entry: './conponents/app.js',
    entry: './src/layout/index.js',
    devtool: 'sourcemaps',
    cache: true,
    mode: 'development',
    output: {
    	path: path.join(__dirname + './../src/main/resources/static/'),
        filename: 'bundle.js'
    },

    module: { // 모듈 연결 설정
        rules: [{
            test: /\.js?/, // 정규식 대상설정
            loader: 'babel-loader',
            options: {
                presets : ['@babel/preset-env','@babel/preset-react'], //js와 jsx 파일에 바벨이 적용됨 
                plugins : ['@babel/plugin-proposal-class-properties'] //state 를 쓸수 있도록 플러그인 추가 
            },
        }],
    },
    
    devServer: {
        hot: true,
        inline: true,
        host: "localhost",
        port: 5500,
        compress: true,
        contentBase: path.join(__dirname, './../src/main/resources/templates/'),
    }
};