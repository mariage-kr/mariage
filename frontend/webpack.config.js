const HtmlWebpackPlugin = require('html-webpack-plugin');
const { CleanWebpackPlugin } = require('clean-webpack-plugin');

const path = require('path');

const webpack = require('webpack');

const dotenv = require('dotenv');
dotenv.config();

module.exports = {
  mode: 'development',
  entry: path.resolve(__dirname, './src/index.tsx'),
  devtool: 'source-map',
  output: {
    path: path.resolve(__dirname, './dist'),
    publicPath: '/',
    filename: '[contenthash].bundle.js',
    clean: true,
  },
  devServer: {
    static: path.resolve(__dirname, './public'),
    port: 3000,
    historyApiFallback: true,
  },
  resolve: {
    extensions: ['.tsx', '.ts', '.js'],
    alias: {
      '@': path.resolve(__dirname, './src/'),
    },
  },
  module: {
    rules: [
      {
        test: /\.tsx?$/,
        use: {
          loader: 'esbuild-loader',
          options: {
            loader: 'tsx',
            target: 'es2015',
          },
        },
      },
      {
        test: /\.(woff(2)?|ttf|png|jpe?g|gif|webp)$/i,
        type: 'asset/resource',
      },
      {
        test: /\.svg$/i,
        issuer: /\.[jt]sx?$/,
        use: ['@svgr/webpack', 'file-loader'],
      },
    ],
  },
  plugins: [
    new webpack.ProvidePlugin({
      React: 'react',
    }),
    new HtmlWebpackPlugin({
      template: 'public/index.html',
    }),
    new CleanWebpackPlugin(),
    new webpack.DefinePlugin({
      'process.env.BASE_URL': JSON.stringify(process.env.BASE_URL),
    }),
  ],
};
