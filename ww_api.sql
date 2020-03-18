/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : ww_api

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 18/03/2020 22:07:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for api_apidetail
-- ----------------------------
DROP TABLE IF EXISTS `api_apidetail`;
CREATE TABLE `api_apidetail`  (
  `apidetail_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章主键id',
  `project_id` int(11) NULL DEFAULT NULL COMMENT '所属项目id',
  `category_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `category_id` int(11) NULL DEFAULT NULL COMMENT '所属分类id',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文章标题',
  `context` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '文章内容',
  `context_html` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '文章内容HTML',
  `despection` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文章描述',
  `getway` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求地址',
  `method` int(11) NULL DEFAULT NULL COMMENT '请求方法(1GET,2POST,3PUT,4DELETE)',
  `requesttype` int(11) NULL DEFAULT NULL COMMENT '请求类型(1json,2xml,3form,4raw)',
  `responsetype` int(11) NULL DEFAULT NULL COMMENT '响应类型(1json,2xml,3jsonp,4html)',
  `request_param` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '请求参数',
  `response_param` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '响应参数',
  `code` int(11) NULL DEFAULT NULL COMMENT '响应状态码',
  `success_goback` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '成功示例',
  `fail_goback` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '失败示例',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文章备注（文章标识）',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  `create_user` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发布人',
  `create_id` int(11) NULL DEFAULT NULL COMMENT '发布人id',
  `version` int(10) NULL DEFAULT 1 COMMENT '版本号',
  `state` tinyint(4) NULL DEFAULT 1 COMMENT '1启用，0废弃',
  `is_new` tinyint(2) NULL DEFAULT 0 COMMENT '是否最新版本，0不是，1最新',
  PRIMARY KEY (`apidetail_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章详情表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of api_apidetail
-- ----------------------------
INSERT INTO `api_apidetail` VALUES (5, 1, NULL, 5, 'aaa', '欢迎使用wwDoc', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-03-03 17:42:47', 'admin', 1, 1, 1, 0);
INSERT INTO `api_apidetail` VALUES (6, 1, NULL, 5, 'aaa', '欢迎使用wwDoc', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-03-03 17:42:54', 'admin', 1, 2, 1, 0);
INSERT INTO `api_apidetail` VALUES (7, 1, NULL, 5, 'aaa', '欢迎使用wwDoc', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-03-03 17:43:12', 'admin', 1, 3, 1, 0);
INSERT INTO `api_apidetail` VALUES (9, 1, '4440', 13, '404', '欢迎使用wwDoc', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-03-04 10:35:55', 'admin', 1, 1, 1, 0);
INSERT INTO `api_apidetail` VALUES (10, 1, '4440', 13, '404', '欢迎使用wwDoc', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-03-04 10:38:41', 'admin', 1, 2, 1, 1);
INSERT INTO `api_apidetail` VALUES (13, 1, '555', 5, 'www', '欢迎使用wwDoc', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-03-04 11:16:46', 'admin', 1, 1, 1, 0);
INSERT INTO `api_apidetail` VALUES (22, 1, '1111', 1, '444', '    \n**简要描述：** \n\n- 用户注册接口\n\n**请求URL：** \n- ` http://xx.com/api/user/register `\n  \n**请求方式：**\n- POST \n\n**参数：** \n\n|参数名|必选|类型|说明|\n|:----    |:---|:----- |-----   |\n|username |是  |string |用户名   |\n|password |是  |string | 密码    |\n|name     |否  |string | 昵称    |\n\n **返回示例**\n\n``` \n  {\n    \"error_code\": 0,\n    \"data\": {\n      \"uid\": \"1\",\n      \"username\": \"12154545\",\n      \"name\": \"吴系挂\",\n      \"groupid\": 2 ,\n      \"reg_time\": \"1436864169\",\n      \"last_login_time\": \"0\",\n    }\n  }\n```\n\n **返回参数说明** \n\n|参数名|类型|说明|\n|:-----  |:-----|-----                           |\n|groupid |int   |用户组id，1：超级管理员；2：普通用户  |\n\n **备注** \n\n- 更多返回错误代码请看首页的错误代码描述\n\n\n欢迎使用wwDoc', '<p><strong>简要描述：</strong> </p>\n<ul>\n<li>用户注册接口</li></ul>\n<p><strong>请求URL：</strong> </p>\n<ul>\n<li><code>http://xx.com/api/user/register</code></li></ul>\n<p><strong>请求方式：</strong></p>\n<ul>\n<li>POST </li></ul>\n<p><strong>参数：</strong> </p>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">参数名</th>\n<th style=\"text-align:left\">必选</th>\n<th style=\"text-align:left\">类型</th>\n<th>说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">username</td>\n<td style=\"text-align:left\">是</td>\n<td style=\"text-align:left\">string</td>\n<td>用户名</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">password</td>\n<td style=\"text-align:left\">是</td>\n<td style=\"text-align:left\">string</td>\n<td>密码</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">name</td>\n<td style=\"text-align:left\">否</td>\n<td style=\"text-align:left\">string</td>\n<td>昵称</td>\n</tr>\n</tbody>\n</table>\n<p> <strong>返回示例</strong></p>\n<pre><code>  {\n    &quot;error_code&quot;: 0,\n    &quot;data&quot;: {\n      &quot;uid&quot;: &quot;1&quot;,\n      &quot;username&quot;: &quot;12154545&quot;,\n      &quot;name&quot;: &quot;吴系挂&quot;,\n      &quot;groupid&quot;: 2 ,\n      &quot;reg_time&quot;: &quot;1436864169&quot;,\n      &quot;last_login_time&quot;: &quot;0&quot;,\n    }\n  }\n</code></pre><p> <strong>返回参数说明</strong> </p>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">参数名</th>\n<th style=\"text-align:left\">类型</th>\n<th>说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">groupid</td>\n<td style=\"text-align:left\">int</td>\n<td>用户组id，1：超级管理员；2：普通用户</td>\n</tr>\n</tbody>\n</table>\n<p> <strong>备注</strong> </p>\n<ul>\n<li>更多返回错误代码请看首页的错误代码描述</li></ul>\n<p>欢迎使用wwDoc</p>\n', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-03-12 14:01:03', 'admin', 1, 1, 1, 0);
INSERT INTO `api_apidetail` VALUES (26, 1, '888', 15, '444', '    \n-  用户表，储存用户信息\n\n|字段|类型|空|默认|注释|\n|:----    |:-------    |:--- |-- -|------      |\n|uid    |int(10)     |否 |  |             |\n|username |varchar(20) |否 |    |   用户名  |\n|password |varchar(50) |否   |    |   密码    |\n|name     |varchar(15) |是   |    |    昵称     |\n|reg_time |int(11)     |否   | 0  |   注册时间  |\n\n- 备注：无\n\n\n    \n**简要描述：** \n\n- 用户注册接口\n\n**请求URL：** \n- ` http://xx.com/api/user/register `\n  \n**请求方式：**\n- POST \n\n**参数：** \n\n|参数名|必选|类型|说明|\n|:----    |:---|:----- |-----   |\n|username |是  |string |用户名   |\n|password |是  |string | 密码    |\n|name     |否  |string | 昵称    |\n\n **返回示例**\n\n``` \n  {\n    \"error_code\": 0,\n    \"data\": {\n      \"uid\": \"1\",\n      \"username\": \"12154545\",\n      \"name\": \"吴系挂\",\n      \"groupid\": 2 ,\n      \"reg_time\": \"1436864169\",\n      \"last_login_time\": \"0\",\n    }\n  }\n```\n\n **返回参数说明** \n\n|参数名|类型|说明|\n|:-----  |:-----|-----                           |\n|groupid |int   |用户组id，1：超级管理员；2：普通用户  |\n\n **备注** \n\n- 更多返回错误代码请看首页的错误代码描述\n\n\n欢迎使用wwDoc\n    \n-  用户表，储存用户信息\n\n|字段|类型|空|默认|注释|\n|:----    |:-------    |:--- |-- -|------      |\n|uid    |int(10)     |否 |  |             |\n|username |varchar(20) |否 |    |   用户名  |\n|password |varchar(50) |否   |    |   密码    |\n|name     |varchar(15) |是   |    |    昵称     |\n|reg_time |int(11)     |否   | 0  |   注册时间  |\n\n- 备注：无\n\n\n    \n**简要描述：** \n\n- 用户注册接口\n\n**请求URL：** \n- ` http://xx.com/api/user/register `\n  \n**请求方式：**\n- POST \n\n**参数：** \n\n|参数名|必选|类型|说明|\n|:----    |:---|:----- |-----   |\n|username |是  |string |用户名   |\n|password |是  |string | 密码    |\n|name     |否  |string | 昵称    |\n\n **返回示例**\n\n``` \n  {\n    \"error_code\": 0,\n    \"data\": {\n      \"uid\": \"1\",\n      \"username\": \"12154545\",\n      \"name\": \"吴系挂\",\n      \"groupid\": 2 ,\n      \"reg_time\": \"1436864169\",\n      \"last_login_time\": \"0\",\n    }\n  }\n```\n\n **返回参数说明** \n\n|参数名|类型|说明|\n|:-----  |:-----|-----                           |\n|groupid |int   |用户组id，1：超级管理员；2：普通用户  |\n\n **备注** \n\n- 更多返回错误代码请看首页的错误代码描述\n\n\n欢迎使用wwDoc', '<ul>\n<li>用户表，储存用户信息</li></ul>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">字段</th>\n<th style=\"text-align:left\">类型</th>\n<th style=\"text-align:left\">空</th>\n<th>默认</th>\n<th>注释</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">uid</td>\n<td style=\"text-align:left\">int(10)</td>\n<td style=\"text-align:left\">否</td>\n<td></td>\n<td></td>\n</tr>\n<tr>\n<td style=\"text-align:left\">username</td>\n<td style=\"text-align:left\">varchar(20)</td>\n<td style=\"text-align:left\">否</td>\n<td></td>\n<td>用户名</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">password</td>\n<td style=\"text-align:left\">varchar(50)</td>\n<td style=\"text-align:left\">否</td>\n<td></td>\n<td>密码</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">name</td>\n<td style=\"text-align:left\">varchar(15)</td>\n<td style=\"text-align:left\">是</td>\n<td></td>\n<td>昵称</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">reg_time</td>\n<td style=\"text-align:left\">int(11)</td>\n<td style=\"text-align:left\">否</td>\n<td>0</td>\n<td>注册时间</td>\n</tr>\n</tbody>\n</table>\n<ul>\n<li>备注：无</li></ul>\n<p><strong>简要描述：</strong> </p>\n<ul>\n<li>用户注册接口</li></ul>\n<p><strong>请求URL：</strong> </p>\n<ul>\n<li><code>http://xx.com/api/user/register</code></li></ul>\n<p><strong>请求方式：</strong></p>\n<ul>\n<li>POST </li></ul>\n<p><strong>参数：</strong> </p>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">参数名</th>\n<th style=\"text-align:left\">必选</th>\n<th style=\"text-align:left\">类型</th>\n<th>说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">username</td>\n<td style=\"text-align:left\">是</td>\n<td style=\"text-align:left\">string</td>\n<td>用户名</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">password</td>\n<td style=\"text-align:left\">是</td>\n<td style=\"text-align:left\">string</td>\n<td>密码</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">name</td>\n<td style=\"text-align:left\">否</td>\n<td style=\"text-align:left\">string</td>\n<td>昵称</td>\n</tr>\n</tbody>\n</table>\n<p> <strong>返回示例</strong></p>\n<pre><code>  {\n    &quot;error_code&quot;: 0,\n    &quot;data&quot;: {\n      &quot;uid&quot;: &quot;1&quot;,\n      &quot;username&quot;: &quot;12154545&quot;,\n      &quot;name&quot;: &quot;吴系挂&quot;,\n      &quot;groupid&quot;: 2 ,\n      &quot;reg_time&quot;: &quot;1436864169&quot;,\n      &quot;last_login_time&quot;: &quot;0&quot;,\n    }\n  }\n</code></pre><p> <strong>返回参数说明</strong> </p>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">参数名</th>\n<th style=\"text-align:left\">类型</th>\n<th>说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">groupid</td>\n<td style=\"text-align:left\">int</td>\n<td>用户组id，1：超级管理员；2：普通用户</td>\n</tr>\n</tbody>\n</table>\n<p> <strong>备注</strong> </p>\n<ul>\n<li>更多返回错误代码请看首页的错误代码描述</li></ul>\n<p>欢迎使用wwDoc</p>\n<ul>\n<li>用户表，储存用户信息</li></ul>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">字段</th>\n<th style=\"text-align:left\">类型</th>\n<th style=\"text-align:left\">空</th>\n<th>默认</th>\n<th>注释</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">uid</td>\n<td style=\"text-align:left\">int(10)</td>\n<td style=\"text-align:left\">否</td>\n<td></td>\n<td></td>\n</tr>\n<tr>\n<td style=\"text-align:left\">username</td>\n<td style=\"text-align:left\">varchar(20)</td>\n<td style=\"text-align:left\">否</td>\n<td></td>\n<td>用户名</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">password</td>\n<td style=\"text-align:left\">varchar(50)</td>\n<td style=\"text-align:left\">否</td>\n<td></td>\n<td>密码</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">name</td>\n<td style=\"text-align:left\">varchar(15)</td>\n<td style=\"text-align:left\">是</td>\n<td></td>\n<td>昵称</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">reg_time</td>\n<td style=\"text-align:left\">int(11)</td>\n<td style=\"text-align:left\">否</td>\n<td>0</td>\n<td>注册时间</td>\n</tr>\n</tbody>\n</table>\n<ul>\n<li>备注：无</li></ul>\n<p><strong>简要描述：</strong> </p>\n<ul>\n<li>用户注册接口</li></ul>\n<p><strong>请求URL：</strong> </p>\n<ul>\n<li><code>http://xx.com/api/user/register</code></li></ul>\n<p><strong>请求方式：</strong></p>\n<ul>\n<li>POST </li></ul>\n<p><strong>参数：</strong> </p>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">参数名</th>\n<th style=\"text-align:left\">必选</th>\n<th style=\"text-align:left\">类型</th>\n<th>说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">username</td>\n<td style=\"text-align:left\">是</td>\n<td style=\"text-align:left\">string</td>\n<td>用户名</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">password</td>\n<td style=\"text-align:left\">是</td>\n<td style=\"text-align:left\">string</td>\n<td>密码</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">name</td>\n<td style=\"text-align:left\">否</td>\n<td style=\"text-align:left\">string</td>\n<td>昵称</td>\n</tr>\n</tbody>\n</table>\n<p> <strong>返回示例</strong></p>\n<pre><code>  {\n    &quot;error_code&quot;: 0,\n    &quot;data&quot;: {\n      &quot;uid&quot;: &quot;1&quot;,\n      &quot;username&quot;: &quot;12154545&quot;,\n      &quot;name&quot;: &quot;吴系挂&quot;,\n      &quot;groupid&quot;: 2 ,\n      &quot;reg_time&quot;: &quot;1436864169&quot;,\n      &quot;last_login_time&quot;: &quot;0&quot;,\n    }\n  }\n</code></pre><p> <strong>返回参数说明</strong> </p>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">参数名</th>\n<th style=\"text-align:left\">类型</th>\n<th>说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">groupid</td>\n<td style=\"text-align:left\">int</td>\n<td>用户组id，1：超级管理员；2：普通用户</td>\n</tr>\n</tbody>\n</table>\n<p> <strong>备注</strong> </p>\n<ul>\n<li>更多返回错误代码请看首页的错误代码描述</li></ul>\n<p>欢迎使用wwDoc</p>\n', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-03-13 17:48:37', 'admin', 1, 1, 1, 0);
INSERT INTO `api_apidetail` VALUES (28, 1, '用户登录', 20, '444', '    \n-  用户表，储存用户信息\n\n|字段|类型|空|默认|注释|\n|:----    |:-------    |:--- |-- -|------      |\n|uid    |int(10)     |否 |  |             |\n|username |varchar(20) |否 |    |   用户名  |\n|password |varchar(50) |否   |    |   密码    |\n|name     |varchar(15) |是   |    |    昵称     |\n|reg_time |int(11)     |否   | 0  |   注册时间  |\n\n- 备注：无\n\n\n    \n**简要描述：** \n\n- 用户注册接口\n\n**请求URL：** \n- ` http://xx.com/api/user/register `\n  \n**请求方式：**\n- POST \n\n**参数：** \n\n|参数名|必选|类型|说明|\n|:----    |:---|:----- |-----   |\n|username |是  |string |用户名   |\n|password |是  |string | 密码    |\n|name     |否  |string | 昵称    |\n\n **返回示例**\n\n``` \n  {\n    \"error_code\": 0,\n    \"data\": {\n      \"uid\": \"1\",\n      \"username\": \"12154545\",\n      \"name\": \"吴系挂\",\n      \"groupid\": 2 ,\n      \"reg_time\": \"1436864169\",\n      \"last_login_time\": \"0\",\n    }\n  }\n```\n\n **返回参数说明** \n\n|参数名|类型|说明|\n|:-----  |:-----|-----                           |\n|groupid |int   |用户组id，1：超级管理员；2：普通用户  |\n\n **备注** \n\n- 更多返回错误代码请看首页的错误代码描述\n\n\n欢迎使用wwDoc\n    \n-  用户表，储存用户信息\n\n|字段|类型|空|默认|注释|\n|:----    |:-------    |:--- |-- -|------      |\n|uid    |int(10)     |否 |  |             |\n|username |varchar(20) |否 |    |   用户名  |\n|password |varchar(50) |否   |    |   密码    |\n|name     |varchar(15) |是   |    |    昵称     |\n|reg_time |int(11)     |否   | 0  |   注册时间  |\n\n- 备注：无\n\n\n    \n**简要描述：** \n\n- 用户注册接口\n\n**请求URL：** \n- ` http://xx.com/api/user/register `\n  \n**请求方式：**\n- POST \n\n**参数：** \n\n|参数名|必选|类型|说明|\n|:----    |:---|:----- |-----   |\n|username |是  |string |用户名   |\n|password |是  |string | 密码    |\n|name     |否  |string | 昵称    |\n\n **返回示例**\n\n``` \n  {\n    \"error_code\": 0,\n    \"data\": {\n      \"uid\": \"1\",\n      \"username\": \"12154545\",\n      \"name\": \"吴系挂\",\n      \"groupid\": 2 ,\n      \"reg_time\": \"1436864169\",\n      \"last_login_time\": \"0\",\n    }\n  }\n```\n\n **返回参数说明** \n\n|参数名|类型|说明|\n|:-----  |:-----|-----                           |\n|groupid |int   |用户组id，1：超级管理员；2：普通用户  |\n\n **备注** \n\n- 更多返回错误代码请看首页的错误代码描述\n\n\n欢迎使用wwDoc', '<ul>\n<li>用户表，储存用户信息</li></ul>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">字段</th>\n<th style=\"text-align:left\">类型</th>\n<th style=\"text-align:left\">空</th>\n<th>默认</th>\n<th>注释</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">uid</td>\n<td style=\"text-align:left\">int(10)</td>\n<td style=\"text-align:left\">否</td>\n<td></td>\n<td></td>\n</tr>\n<tr>\n<td style=\"text-align:left\">username</td>\n<td style=\"text-align:left\">varchar(20)</td>\n<td style=\"text-align:left\">否</td>\n<td></td>\n<td>用户名</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">password</td>\n<td style=\"text-align:left\">varchar(50)</td>\n<td style=\"text-align:left\">否</td>\n<td></td>\n<td>密码</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">name</td>\n<td style=\"text-align:left\">varchar(15)</td>\n<td style=\"text-align:left\">是</td>\n<td></td>\n<td>昵称</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">reg_time</td>\n<td style=\"text-align:left\">int(11)</td>\n<td style=\"text-align:left\">否</td>\n<td>0</td>\n<td>注册时间</td>\n</tr>\n</tbody>\n</table>\n<ul>\n<li>备注：无</li></ul>\n<p><strong>简要描述：</strong> </p>\n<ul>\n<li>用户注册接口</li></ul>\n<p><strong>请求URL：</strong> </p>\n<ul>\n<li><code>http://xx.com/api/user/register</code></li></ul>\n<p><strong>请求方式：</strong></p>\n<ul>\n<li>POST </li></ul>\n<p><strong>参数：</strong> </p>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">参数名</th>\n<th style=\"text-align:left\">必选</th>\n<th style=\"text-align:left\">类型</th>\n<th>说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">username</td>\n<td style=\"text-align:left\">是</td>\n<td style=\"text-align:left\">string</td>\n<td>用户名</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">password</td>\n<td style=\"text-align:left\">是</td>\n<td style=\"text-align:left\">string</td>\n<td>密码</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">name</td>\n<td style=\"text-align:left\">否</td>\n<td style=\"text-align:left\">string</td>\n<td>昵称</td>\n</tr>\n</tbody>\n</table>\n<p> <strong>返回示例</strong></p>\n<pre><code>  {\n    &quot;error_code&quot;: 0,\n    &quot;data&quot;: {\n      &quot;uid&quot;: &quot;1&quot;,\n      &quot;username&quot;: &quot;12154545&quot;,\n      &quot;name&quot;: &quot;吴系挂&quot;,\n      &quot;groupid&quot;: 2 ,\n      &quot;reg_time&quot;: &quot;1436864169&quot;,\n      &quot;last_login_time&quot;: &quot;0&quot;,\n    }\n  }\n</code></pre><p> <strong>返回参数说明</strong> </p>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">参数名</th>\n<th style=\"text-align:left\">类型</th>\n<th>说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">groupid</td>\n<td style=\"text-align:left\">int</td>\n<td>用户组id，1：超级管理员；2：普通用户</td>\n</tr>\n</tbody>\n</table>\n<p> <strong>备注</strong> </p>\n<ul>\n<li>更多返回错误代码请看首页的错误代码描述</li></ul>\n<p>欢迎使用wwDoc</p>\n<ul>\n<li>用户表，储存用户信息</li></ul>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">字段</th>\n<th style=\"text-align:left\">类型</th>\n<th style=\"text-align:left\">空</th>\n<th>默认</th>\n<th>注释</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">uid</td>\n<td style=\"text-align:left\">int(10)</td>\n<td style=\"text-align:left\">否</td>\n<td></td>\n<td></td>\n</tr>\n<tr>\n<td style=\"text-align:left\">username</td>\n<td style=\"text-align:left\">varchar(20)</td>\n<td style=\"text-align:left\">否</td>\n<td></td>\n<td>用户名</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">password</td>\n<td style=\"text-align:left\">varchar(50)</td>\n<td style=\"text-align:left\">否</td>\n<td></td>\n<td>密码</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">name</td>\n<td style=\"text-align:left\">varchar(15)</td>\n<td style=\"text-align:left\">是</td>\n<td></td>\n<td>昵称</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">reg_time</td>\n<td style=\"text-align:left\">int(11)</td>\n<td style=\"text-align:left\">否</td>\n<td>0</td>\n<td>注册时间</td>\n</tr>\n</tbody>\n</table>\n<ul>\n<li>备注：无</li></ul>\n<p><strong>简要描述：</strong> </p>\n<ul>\n<li>用户注册接口</li></ul>\n<p><strong>请求URL：</strong> </p>\n<ul>\n<li><code>http://xx.com/api/user/register</code></li></ul>\n<p><strong>请求方式：</strong></p>\n<ul>\n<li>POST </li></ul>\n<p><strong>参数：</strong> </p>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">参数名</th>\n<th style=\"text-align:left\">必选</th>\n<th style=\"text-align:left\">类型</th>\n<th>说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">username</td>\n<td style=\"text-align:left\">是</td>\n<td style=\"text-align:left\">string</td>\n<td>用户名</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">password</td>\n<td style=\"text-align:left\">是</td>\n<td style=\"text-align:left\">string</td>\n<td>密码</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">name</td>\n<td style=\"text-align:left\">否</td>\n<td style=\"text-align:left\">string</td>\n<td>昵称</td>\n</tr>\n</tbody>\n</table>\n<p> <strong>返回示例</strong></p>\n<pre><code>  {\n    &quot;error_code&quot;: 0,\n    &quot;data&quot;: {\n      &quot;uid&quot;: &quot;1&quot;,\n      &quot;username&quot;: &quot;12154545&quot;,\n      &quot;name&quot;: &quot;吴系挂&quot;,\n      &quot;groupid&quot;: 2 ,\n      &quot;reg_time&quot;: &quot;1436864169&quot;,\n      &quot;last_login_time&quot;: &quot;0&quot;,\n    }\n  }\n</code></pre><p> <strong>返回参数说明</strong> </p>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">参数名</th>\n<th style=\"text-align:left\">类型</th>\n<th>说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">groupid</td>\n<td style=\"text-align:left\">int</td>\n<td>用户组id，1：超级管理员；2：普通用户</td>\n</tr>\n</tbody>\n</table>\n<p> <strong>备注</strong> </p>\n<ul>\n<li>更多返回错误代码请看首页的错误代码描述</li></ul>\n<p>欢迎使用wwDoc</p>\n', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-03-15 16:25:44', 'admin', 1, 1, 1, 0);
INSERT INTO `api_apidetail` VALUES (29, 1, '用户登录', 20, '登录接口', '    \n-  用户表，储存用户信息\n\n|字段|类型|空|默认|注释|\n|:----    |:-------    |:--- |-- -|------      |\n|uid    |int(10)     |否 |  |             |\n|username |varchar(20) |否 |    |   用户名  |\n|password |varchar(50) |否   |    |   密码    |\n|name     |varchar(15) |是   |    |    昵称     |\n|reg_time |int(11)     |否   | 0  |   注册时间  |\n\n- 备注：无\n\n\n    \n**简要描述：** \n\n- 用户注册接口\n\n**请求URL：** \n- ` http://xx.com/api/user/register `\n  \n**请求方式：**\n- POST \n\n**参数：** \n\n|参数名|必选|类型|说明|\n|:----    |:---|:----- |-----   |\n|username |是  |string |用户名   |\n|password |是  |string | 密码    |\n|name     |否  |string | 昵称    |\n\n **返回示例**\n\n``` \n  {\n    \"error_code\": 0,\n    \"data\": {\n      \"uid\": \"1\",\n      \"username\": \"12154545\",\n      \"name\": \"吴系挂\",\n      \"groupid\": 2 ,\n      \"reg_time\": \"1436864169\",\n      \"last_login_time\": \"0\",\n    }\n  }\n```\n\n **返回参数说明** \n\n|参数名|类型|说明|\n|:-----  |:-----|-----                           |\n|groupid |int   |用户组id，1：超级管理员；2：普通用户  |\n\n **备注** \n\n- 更多返回错误代码请看首页的错误代码描述\n\n\n欢迎使用wwDoc\n    \n-  用户表，储存用户信息\n\n|字段|类型|空|默认|注释|\n|:----    |:-------    |:--- |-- -|------      |\n|uid    |int(10)     |否 |  |             |\n|username |varchar(20) |否 |    |   用户名  |\n|password |varchar(50) |否   |    |   密码    |\n|name     |varchar(15) |是   |    |    昵称     |\n|reg_time |int(11)     |否   | 0  |   注册时间  |\n\n- 备注：无\n\n\n    \n**简要描述：** \n\n- 用户注册接口\n\n**请求URL：** \n- ` http://xx.com/api/user/register `\n  \n**请求方式：**\n- POST \n\n**参数：** \n\n|参数名|必选|类型|说明|\n|:----    |:---|:----- |-----   |\n|username |是  |string |用户名   |\n|password |是  |string | 密码    |\n|name     |否  |string | 昵称    |\n\n **返回示例**\n\n``` \n  {\n    \"error_code\": 0,\n    \"data\": {\n      \"uid\": \"1\",\n      \"username\": \"12154545\",\n      \"name\": \"吴系挂\",\n      \"groupid\": 2 ,\n      \"reg_time\": \"1436864169\",\n      \"last_login_time\": \"0\",\n    }\n  }\n```\n\n **返回参数说明** \n\n|参数名|类型|说明|\n|:-----  |:-----|-----                           |\n|groupid |int   |用户组id，1：超级管理员；2：普通用户  |\n\n **备注** \n\n- 更多返回错误代码请看首页的错误代码描述\n\n\n欢迎使用wwDoc', '<ul>\n<li>用户表，储存用户信息</li></ul>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">字段</th>\n<th style=\"text-align:left\">类型</th>\n<th style=\"text-align:left\">空</th>\n<th>默认</th>\n<th>注释</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">uid</td>\n<td style=\"text-align:left\">int(10)</td>\n<td style=\"text-align:left\">否</td>\n<td></td>\n<td></td>\n</tr>\n<tr>\n<td style=\"text-align:left\">username</td>\n<td style=\"text-align:left\">varchar(20)</td>\n<td style=\"text-align:left\">否</td>\n<td></td>\n<td>用户名</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">password</td>\n<td style=\"text-align:left\">varchar(50)</td>\n<td style=\"text-align:left\">否</td>\n<td></td>\n<td>密码</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">name</td>\n<td style=\"text-align:left\">varchar(15)</td>\n<td style=\"text-align:left\">是</td>\n<td></td>\n<td>昵称</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">reg_time</td>\n<td style=\"text-align:left\">int(11)</td>\n<td style=\"text-align:left\">否</td>\n<td>0</td>\n<td>注册时间</td>\n</tr>\n</tbody>\n</table>\n<ul>\n<li>备注：无</li></ul>\n<p><strong>简要描述：</strong> </p>\n<ul>\n<li>用户注册接口</li></ul>\n<p><strong>请求URL：</strong> </p>\n<ul>\n<li><code>http://xx.com/api/user/register</code></li></ul>\n<p><strong>请求方式：</strong></p>\n<ul>\n<li>POST </li></ul>\n<p><strong>参数：</strong> </p>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">参数名</th>\n<th style=\"text-align:left\">必选</th>\n<th style=\"text-align:left\">类型</th>\n<th>说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">username</td>\n<td style=\"text-align:left\">是</td>\n<td style=\"text-align:left\">string</td>\n<td>用户名</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">password</td>\n<td style=\"text-align:left\">是</td>\n<td style=\"text-align:left\">string</td>\n<td>密码</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">name</td>\n<td style=\"text-align:left\">否</td>\n<td style=\"text-align:left\">string</td>\n<td>昵称</td>\n</tr>\n</tbody>\n</table>\n<p> <strong>返回示例</strong></p>\n<pre><code>  {\n    &quot;error_code&quot;: 0,\n    &quot;data&quot;: {\n      &quot;uid&quot;: &quot;1&quot;,\n      &quot;username&quot;: &quot;12154545&quot;,\n      &quot;name&quot;: &quot;吴系挂&quot;,\n      &quot;groupid&quot;: 2 ,\n      &quot;reg_time&quot;: &quot;1436864169&quot;,\n      &quot;last_login_time&quot;: &quot;0&quot;,\n    }\n  }\n</code></pre><p> <strong>返回参数说明</strong> </p>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">参数名</th>\n<th style=\"text-align:left\">类型</th>\n<th>说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">groupid</td>\n<td style=\"text-align:left\">int</td>\n<td>用户组id，1：超级管理员；2：普通用户</td>\n</tr>\n</tbody>\n</table>\n<p> <strong>备注</strong> </p>\n<ul>\n<li>更多返回错误代码请看首页的错误代码描述</li></ul>\n<p>欢迎使用wwDoc</p>\n<ul>\n<li>用户表，储存用户信息</li></ul>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">字段</th>\n<th style=\"text-align:left\">类型</th>\n<th style=\"text-align:left\">空</th>\n<th>默认</th>\n<th>注释</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">uid</td>\n<td style=\"text-align:left\">int(10)</td>\n<td style=\"text-align:left\">否</td>\n<td></td>\n<td></td>\n</tr>\n<tr>\n<td style=\"text-align:left\">username</td>\n<td style=\"text-align:left\">varchar(20)</td>\n<td style=\"text-align:left\">否</td>\n<td></td>\n<td>用户名</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">password</td>\n<td style=\"text-align:left\">varchar(50)</td>\n<td style=\"text-align:left\">否</td>\n<td></td>\n<td>密码</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">name</td>\n<td style=\"text-align:left\">varchar(15)</td>\n<td style=\"text-align:left\">是</td>\n<td></td>\n<td>昵称</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">reg_time</td>\n<td style=\"text-align:left\">int(11)</td>\n<td style=\"text-align:left\">否</td>\n<td>0</td>\n<td>注册时间</td>\n</tr>\n</tbody>\n</table>\n<ul>\n<li>备注：无</li></ul>\n<p><strong>简要描述：</strong> </p>\n<ul>\n<li>用户注册接口</li></ul>\n<p><strong>请求URL：</strong> </p>\n<ul>\n<li><code>http://xx.com/api/user/register</code></li></ul>\n<p><strong>请求方式：</strong></p>\n<ul>\n<li>POST </li></ul>\n<p><strong>参数：</strong> </p>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">参数名</th>\n<th style=\"text-align:left\">必选</th>\n<th style=\"text-align:left\">类型</th>\n<th>说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">username</td>\n<td style=\"text-align:left\">是</td>\n<td style=\"text-align:left\">string</td>\n<td>用户名</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">password</td>\n<td style=\"text-align:left\">是</td>\n<td style=\"text-align:left\">string</td>\n<td>密码</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">name</td>\n<td style=\"text-align:left\">否</td>\n<td style=\"text-align:left\">string</td>\n<td>昵称</td>\n</tr>\n</tbody>\n</table>\n<p> <strong>返回示例</strong></p>\n<pre><code>  {\n    &quot;error_code&quot;: 0,\n    &quot;data&quot;: {\n      &quot;uid&quot;: &quot;1&quot;,\n      &quot;username&quot;: &quot;12154545&quot;,\n      &quot;name&quot;: &quot;吴系挂&quot;,\n      &quot;groupid&quot;: 2 ,\n      &quot;reg_time&quot;: &quot;1436864169&quot;,\n      &quot;last_login_time&quot;: &quot;0&quot;,\n    }\n  }\n</code></pre><p> <strong>返回参数说明</strong> </p>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">参数名</th>\n<th style=\"text-align:left\">类型</th>\n<th>说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">groupid</td>\n<td style=\"text-align:left\">int</td>\n<td>用户组id，1：超级管理员；2：普通用户</td>\n</tr>\n</tbody>\n</table>\n<p> <strong>备注</strong> </p>\n<ul>\n<li>更多返回错误代码请看首页的错误代码描述</li></ul>\n<p>欢迎使用wwDoc</p>\n', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-03-15 16:44:00', 'admin', 1, 1, 1, 1);
INSERT INTO `api_apidetail` VALUES (30, 1, '用户登录', 20, '444', '    \n-  用户表，储存用户信息\n\n|字段|类型|空|默认|注释|\n|:----    |:-------    |:--- |-- -|------      |\n|uid    |int(10)     |否 |  |             |\n|username |varchar(20) |否 |    |   用户名  |\n|password |varchar(50) |否   |    |   密码    |\n|name     |varchar(15) |是   |    |    昵称     |\n|reg_time |int(11)     |否   | 0  |   注册时间  |\n\n- 备注：无\n\n\n    \n**简要描述：** \n\n- 用户注册接口\n\n**请求URL：** \n- ` http://xx.com/api/user/register `\n  \n**请求方式：**\n- POST \n\n**参数：** \n\n|参数名|必选|类型|说明|\n|:----    |:---|:----- |-----   |\n|username |是  |string |用户名   |\n|password |是  |string | 密码    |\n|name     |否  |string | 昵称    |\n\n **返回示例**\n\n``` \n  {\n    \"error_code\": 0,\n    \"data\": {\n      \"uid\": \"1\",\n      \"username\": \"12154545\",\n      \"name\": \"吴系挂\",\n      \"groupid\": 2 ,\n      \"reg_time\": \"1436864169\",\n      \"last_login_time\": \"0\",\n    }\n  }\n```\n\n **返回参数说明** \n\n|参数名|类型|说明|\n|:-----  |:-----|-----                           |\n|groupid |int   |用户组id，1：超级管理员；2：普通用户  |\n\n **备注** \n\n- 更多返回错误代码请看首页的错误代码描述\n\n\n欢迎使用wwDoc\n    \n-  用户表，储存用户信息\n\n|字段|类型|空|默认|注释|\n|:----    |:-------    |:--- |-- -|------      |\n|uid    |int(10)     |否 |  |             |\n|username |varchar(20) |否 |    |   用户名  |\n|password |varchar(50) |否   |    |   密码    |\n|name     |varchar(15) |是   |    |    昵称     |\n|reg_time |int(11)     |否   | 0  |   注册时间  |\n\n- 备注：无\n\n\n    \n**简要描述：** \n\n- 用户注册接口\n\n**请求URL：** \n- ` http://xx.com/api/user/register `\n  \n**请求方式：**\n- POST \n\n**参数：** \n\n|参数名|必选|类型|说明|\n|:----    |:---|:----- |-----   |\n|username |是  |string |用户名   |\n|password |是  |string | 密码    |\n|name     |否  |string | 昵称    |\n\n **返回示例**\n\n``` \n  {\n    \"error_code\": 0,\n    \"data\": {\n      \"uid\": \"1\",\n      \"username\": \"12154545\",\n      \"name\": \"吴系挂\",\n      \"groupid\": 2 ,\n      \"reg_time\": \"1436864169\",\n      \"last_login_time\": \"0\",\n    }\n  }\n```\n\n **返回参数说明** \n\n|参数名|类型|说明|\n|:-----  |:-----|-----                           |\n|groupid |int   |用户组id，1：超级管理员；2：普通用户  |\n\n **备注** \n\n- 更多返回错误代码请看首页的错误代码描述\n\n\n欢迎使用wwDoc', '<ul>\n<li>用户表，储存用户信息</li></ul>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">字段</th>\n<th style=\"text-align:left\">类型</th>\n<th style=\"text-align:left\">空</th>\n<th>默认</th>\n<th>注释</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">uid</td>\n<td style=\"text-align:left\">int(10)</td>\n<td style=\"text-align:left\">否</td>\n<td></td>\n<td></td>\n</tr>\n<tr>\n<td style=\"text-align:left\">username</td>\n<td style=\"text-align:left\">varchar(20)</td>\n<td style=\"text-align:left\">否</td>\n<td></td>\n<td>用户名</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">password</td>\n<td style=\"text-align:left\">varchar(50)</td>\n<td style=\"text-align:left\">否</td>\n<td></td>\n<td>密码</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">name</td>\n<td style=\"text-align:left\">varchar(15)</td>\n<td style=\"text-align:left\">是</td>\n<td></td>\n<td>昵称</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">reg_time</td>\n<td style=\"text-align:left\">int(11)</td>\n<td style=\"text-align:left\">否</td>\n<td>0</td>\n<td>注册时间</td>\n</tr>\n</tbody>\n</table>\n<ul>\n<li>备注：无</li></ul>\n<p><strong>简要描述：</strong> </p>\n<ul>\n<li>用户注册接口</li></ul>\n<p><strong>请求URL：</strong> </p>\n<ul>\n<li><code>http://xx.com/api/user/register</code></li></ul>\n<p><strong>请求方式：</strong></p>\n<ul>\n<li>POST </li></ul>\n<p><strong>参数：</strong> </p>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">参数名</th>\n<th style=\"text-align:left\">必选</th>\n<th style=\"text-align:left\">类型</th>\n<th>说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">username</td>\n<td style=\"text-align:left\">是</td>\n<td style=\"text-align:left\">string</td>\n<td>用户名</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">password</td>\n<td style=\"text-align:left\">是</td>\n<td style=\"text-align:left\">string</td>\n<td>密码</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">name</td>\n<td style=\"text-align:left\">否</td>\n<td style=\"text-align:left\">string</td>\n<td>昵称</td>\n</tr>\n</tbody>\n</table>\n<p> <strong>返回示例</strong></p>\n<pre><code>  {\n    &quot;error_code&quot;: 0,\n    &quot;data&quot;: {\n      &quot;uid&quot;: &quot;1&quot;,\n      &quot;username&quot;: &quot;12154545&quot;,\n      &quot;name&quot;: &quot;吴系挂&quot;,\n      &quot;groupid&quot;: 2 ,\n      &quot;reg_time&quot;: &quot;1436864169&quot;,\n      &quot;last_login_time&quot;: &quot;0&quot;,\n    }\n  }\n</code></pre><p> <strong>返回参数说明</strong> </p>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">参数名</th>\n<th style=\"text-align:left\">类型</th>\n<th>说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">groupid</td>\n<td style=\"text-align:left\">int</td>\n<td>用户组id，1：超级管理员；2：普通用户</td>\n</tr>\n</tbody>\n</table>\n<p> <strong>备注</strong> </p>\n<ul>\n<li>更多返回错误代码请看首页的错误代码描述</li></ul>\n<p>欢迎使用wwDoc</p>\n<ul>\n<li>用户表，储存用户信息</li></ul>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">字段</th>\n<th style=\"text-align:left\">类型</th>\n<th style=\"text-align:left\">空</th>\n<th>默认</th>\n<th>注释</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">uid</td>\n<td style=\"text-align:left\">int(10)</td>\n<td style=\"text-align:left\">否</td>\n<td></td>\n<td></td>\n</tr>\n<tr>\n<td style=\"text-align:left\">username</td>\n<td style=\"text-align:left\">varchar(20)</td>\n<td style=\"text-align:left\">否</td>\n<td></td>\n<td>用户名</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">password</td>\n<td style=\"text-align:left\">varchar(50)</td>\n<td style=\"text-align:left\">否</td>\n<td></td>\n<td>密码</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">name</td>\n<td style=\"text-align:left\">varchar(15)</td>\n<td style=\"text-align:left\">是</td>\n<td></td>\n<td>昵称</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">reg_time</td>\n<td style=\"text-align:left\">int(11)</td>\n<td style=\"text-align:left\">否</td>\n<td>0</td>\n<td>注册时间</td>\n</tr>\n</tbody>\n</table>\n<ul>\n<li>备注：无</li></ul>\n<p><strong>简要描述：</strong> </p>\n<ul>\n<li>用户注册接口</li></ul>\n<p><strong>请求URL：</strong> </p>\n<ul>\n<li><code>http://xx.com/api/user/register</code></li></ul>\n<p><strong>请求方式：</strong></p>\n<ul>\n<li>POST </li></ul>\n<p><strong>参数：</strong> </p>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">参数名</th>\n<th style=\"text-align:left\">必选</th>\n<th style=\"text-align:left\">类型</th>\n<th>说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">username</td>\n<td style=\"text-align:left\">是</td>\n<td style=\"text-align:left\">string</td>\n<td>用户名</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">password</td>\n<td style=\"text-align:left\">是</td>\n<td style=\"text-align:left\">string</td>\n<td>密码</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">name</td>\n<td style=\"text-align:left\">否</td>\n<td style=\"text-align:left\">string</td>\n<td>昵称</td>\n</tr>\n</tbody>\n</table>\n<p> <strong>返回示例</strong></p>\n<pre><code>  {\n    &quot;error_code&quot;: 0,\n    &quot;data&quot;: {\n      &quot;uid&quot;: &quot;1&quot;,\n      &quot;username&quot;: &quot;12154545&quot;,\n      &quot;name&quot;: &quot;吴系挂&quot;,\n      &quot;groupid&quot;: 2 ,\n      &quot;reg_time&quot;: &quot;1436864169&quot;,\n      &quot;last_login_time&quot;: &quot;0&quot;,\n    }\n  }\n</code></pre><p> <strong>返回参数说明</strong> </p>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">参数名</th>\n<th style=\"text-align:left\">类型</th>\n<th>说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">groupid</td>\n<td style=\"text-align:left\">int</td>\n<td>用户组id，1：超级管理员；2：普通用户</td>\n</tr>\n</tbody>\n</table>\n<p> <strong>备注</strong> </p>\n<ul>\n<li>更多返回错误代码请看首页的错误代码描述</li></ul>\n<p>欢迎使用wwDoc</p>\n', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-03-15 16:52:44', 'admin', 1, 2, 1, 1);
INSERT INTO `api_apidetail` VALUES (31, 1, '用户模块', 19, '注册接口', '    \n**简要描述：** \n\n- 用户注册接口\n\n**请求URL：** \n- ` http://xx.com/api/user/register `\n  \n**请求方式：**\n- POST \n\n**参数：** \n\n|参数名|必选|类型|说明|\n|:----    |:---|:----- |-----   |\n|username |是  |string |用户名   |\n|password |是  |string | 密码    |\n|name     |否  |string | 昵称    |\n\n **返回示例**\n\n``` \n  {\n    \"error_code\": 0,\n    \"data\": {\n      \"uid\": \"1\",\n      \"username\": \"12154545\",\n      \"name\": \"吴系挂\",\n      \"groupid\": 2 ,\n      \"reg_time\": \"1436864169\",\n      \"last_login_time\": \"0\",\n    }\n  }\n```\n\n **返回参数说明** \n\n|参数名|类型|说明|\n|:-----  |:-----|-----                           |\n|groupid |int   |用户组id，1：超级管理员；2：普通用户  |\n\n **备注** \n\n- 更多返回错误代码请看首页的错误代码描述\n\n\n欢迎使用wwDoc', '<p><strong>简要描述：</strong> </p>\n<ul>\n<li>用户注册接口</li></ul>\n<p><strong>请求URL：</strong> </p>\n<ul>\n<li><code>http://xx.com/api/user/register</code></li></ul>\n<p><strong>请求方式：</strong></p>\n<ul>\n<li>POST </li></ul>\n<p><strong>参数：</strong> </p>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">参数名</th>\n<th style=\"text-align:left\">必选</th>\n<th style=\"text-align:left\">类型</th>\n<th>说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">username</td>\n<td style=\"text-align:left\">是</td>\n<td style=\"text-align:left\">string</td>\n<td>用户名</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">password</td>\n<td style=\"text-align:left\">是</td>\n<td style=\"text-align:left\">string</td>\n<td>密码</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">name</td>\n<td style=\"text-align:left\">否</td>\n<td style=\"text-align:left\">string</td>\n<td>昵称</td>\n</tr>\n</tbody>\n</table>\n<p> <strong>返回示例</strong></p>\n<pre><code>  {\n    &quot;error_code&quot;: 0,\n    &quot;data&quot;: {\n      &quot;uid&quot;: &quot;1&quot;,\n      &quot;username&quot;: &quot;12154545&quot;,\n      &quot;name&quot;: &quot;吴系挂&quot;,\n      &quot;groupid&quot;: 2 ,\n      &quot;reg_time&quot;: &quot;1436864169&quot;,\n      &quot;last_login_time&quot;: &quot;0&quot;,\n    }\n  }\n</code></pre><p> <strong>返回参数说明</strong> </p>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">参数名</th>\n<th style=\"text-align:left\">类型</th>\n<th>说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">groupid</td>\n<td style=\"text-align:left\">int</td>\n<td>用户组id，1：超级管理员；2：普通用户</td>\n</tr>\n</tbody>\n</table>\n<p> <strong>备注</strong> </p>\n<ul>\n<li>更多返回错误代码请看首页的错误代码描述</li></ul>\n', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-03-15 16:55:04', 'admin', 1, 1, 1, 0);
INSERT INTO `api_apidetail` VALUES (32, 1, '线路', 22, '添加线路', '欢迎使用wwDoc', '<p>欢迎使用wwDoc</p>\n', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-03-15 16:56:47', 'admin', 1, 1, 1, 1);
INSERT INTO `api_apidetail` VALUES (33, 1, '用户模块', 19, '注册接口', '    \n**简要描述：** \n\n- 用户注册接口\n\n**请求URL：** \n- ` http://xx.com/api/user/register `\n  \n**请求方式：**\n- POST \n\n**参数：** \n\n|参数名|必选|类型|说明|\n|:----    |:---|:----- |-----   |\n|username |是  |string |用户名   |\n|password |是  |string | 密码    |\n|name     |否  |string | 昵称    |\n\n **返回示例**\n\n``` \n  {\n    \"error_code\": 0,\n    \"data\": {\n      \"uid\": \"1\",\n      \"username\": \"12154545\",\n      \"name\": \"吴系挂\",\n      \"groupid\": 2 ,\n      \"reg_time\": \"1436864169\",\n      \"last_login_time\": \"0\",\n    }\n  }\n```\n\n **返回参数说明** \n\n|参数名|类型|说明|\n|:-----  |:-----|-----                           |\n|groupid |int   |用户组id，1：超级管理员；2：普通用户  |\n\n **备注** \n\n- 更多返回错误代码请看首页的错误代码描述\n\n\n欢迎使用wwDoc', '<p><strong>简要描述：</strong> </p>\n<ul>\n<li>用户注册接口</li></ul>\n<p><strong>请求URL：</strong> </p>\n<ul>\n<li><code>http://xx.com/api/user/register</code></li></ul>\n<p><strong>请求方式：</strong></p>\n<ul>\n<li>POST </li></ul>\n<p><strong>参数：</strong> </p>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">参数名</th>\n<th style=\"text-align:left\">必选</th>\n<th style=\"text-align:left\">类型</th>\n<th>说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">username</td>\n<td style=\"text-align:left\">是</td>\n<td style=\"text-align:left\">string</td>\n<td>用户名</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">password</td>\n<td style=\"text-align:left\">是</td>\n<td style=\"text-align:left\">string</td>\n<td>密码</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">name</td>\n<td style=\"text-align:left\">否</td>\n<td style=\"text-align:left\">string</td>\n<td>昵称</td>\n</tr>\n</tbody>\n</table>\n<p> <strong>返回示例</strong></p>\n<pre><code>  {\n    &quot;error_code&quot;: 0,\n    &quot;data&quot;: {\n      &quot;uid&quot;: &quot;1&quot;,\n      &quot;username&quot;: &quot;12154545&quot;,\n      &quot;name&quot;: &quot;吴系挂&quot;,\n      &quot;groupid&quot;: 2 ,\n      &quot;reg_time&quot;: &quot;1436864169&quot;,\n      &quot;last_login_time&quot;: &quot;0&quot;,\n    }\n  }\n</code></pre><p> <strong>返回参数说明</strong> </p>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">参数名</th>\n<th style=\"text-align:left\">类型</th>\n<th>说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">groupid</td>\n<td style=\"text-align:left\">int</td>\n<td>用户组id，1：超级管理员；2：普通用户</td>\n</tr>\n</tbody>\n</table>\n<p> <strong>备注</strong> </p>\n<ul>\n<li>更多返回错误代码请看首页的错误代码描述</li></ul>\n<p>欢迎使用wwDoc</p>\n', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '3e77778611f646a98cd286935ba520a2', '2020-03-17 18:36:35', 'admin', 1, 1, 1, 1);
INSERT INTO `api_apidetail` VALUES (34, 1, '用户模块', 19, '注册接口', '    \n**简要描述：** \n\n- 用户注册接口\n\n**请求URL：** \n- ` http://xx.com/api/user/register `\n  \n**请求方式：**\n- POST \n\n**参数：** \n\n|参数名|必选|类型|说明|\n|:----    |:---|:----- |-----   |\n|username |是  |string |用户名   |\n|password |是  |string | 密码    |\n|name     |否  |string | 昵称    |\n\n **返回示例**\n\n``` \n  {\n    \"error_code\": 0,\n    \"data\": {\n      \"uid\": \"1\",\n      \"username\": \"12154545\",\n      \"name\": \"吴系挂\",\n      \"groupid\": 2 ,\n      \"reg_time\": \"1436864169\",\n      \"last_login_time\": \"0\",\n    }\n  }\n```\n\n **返回参数说明** \n\n|参数名|类型|说明|\n|:-----  |:-----|-----                           |\n|groupid |int   |用户组id，1：超级管理员；2：普通用户  |\n\n **备注** \n\n- 更多返回错误代码请看首页的错误代码描述\n\n\n欢迎使用wwDoc', '<p><strong>简要描述：</strong> </p>\n<ul>\n<li>用户注册接口</li></ul>\n<p><strong>请求URL：</strong> </p>\n<ul>\n<li><code>http://xx.com/api/user/register</code></li></ul>\n<p><strong>请求方式：</strong></p>\n<ul>\n<li>POST </li></ul>\n<p><strong>参数：</strong> </p>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">参数名</th>\n<th style=\"text-align:left\">必选</th>\n<th style=\"text-align:left\">类型</th>\n<th>说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">username</td>\n<td style=\"text-align:left\">是</td>\n<td style=\"text-align:left\">string</td>\n<td>用户名</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">password</td>\n<td style=\"text-align:left\">是</td>\n<td style=\"text-align:left\">string</td>\n<td>密码</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">name</td>\n<td style=\"text-align:left\">否</td>\n<td style=\"text-align:left\">string</td>\n<td>昵称</td>\n</tr>\n</tbody>\n</table>\n<p> <strong>返回示例</strong></p>\n<pre><code>  {\n    &quot;error_code&quot;: 0,\n    &quot;data&quot;: {\n      &quot;uid&quot;: &quot;1&quot;,\n      &quot;username&quot;: &quot;12154545&quot;,\n      &quot;name&quot;: &quot;吴系挂&quot;,\n      &quot;groupid&quot;: 2 ,\n      &quot;reg_time&quot;: &quot;1436864169&quot;,\n      &quot;last_login_time&quot;: &quot;0&quot;,\n    }\n  }\n</code></pre><p> <strong>返回参数说明</strong> </p>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">参数名</th>\n<th style=\"text-align:left\">类型</th>\n<th>说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">groupid</td>\n<td style=\"text-align:left\">int</td>\n<td>用户组id，1：超级管理员；2：普通用户</td>\n</tr>\n</tbody>\n</table>\n<p> <strong>备注</strong> </p>\n<ul>\n<li>更多返回错误代码请看首页的错误代码描述</li></ul>\n<p>欢迎使用wwDoc</p>\n', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'a50f75254beb4d14b634b38c17f59072', '2020-03-17 18:37:12', 'admin', 1, 1, 1, 1);
INSERT INTO `api_apidetail` VALUES (35, 1, '用户模块', 19, '注册接口', '    \n**简要描述：** \n\n- 用户注册接口\n\n**请求URL：** \n- ` http://xx.com/api/user/register `\n  \n**请求方式：**\n- POST \n\n**参数：** \n\n|参数名|必选|类型|说明|\n|:----    |:---|:----- |-----   |\n|username |是  |string |用户名   |\n|password |是  |string | 密码    |\n|name     |否  |string | 昵称    |\n\n **返回示例**\n\n``` \n  {\n    \"error_code\": 0,\n    \"data\": {\n      \"uid\": \"1\",\n      \"username\": \"12154545\",\n      \"name\": \"吴系挂\",\n      \"groupid\": 2 ,\n      \"reg_time\": \"1436864169\",\n      \"last_login_time\": \"0\",\n    }\n  }\n```\n\n **返回参数说明** \n\n|参数名|类型|说明|\n|:-----  |:-----|-----                           |\n|groupid |int   |用户组id，1：超级管理员；2：普通用户  |\n\n **备注** \n\n- 更多返回错误代码请看首页的错误代码描述\n\n\n欢迎使用wwDoc', '<p><strong>简要描述：</strong> </p>\n<ul>\n<li>用户注册接口</li></ul>\n<p><strong>请求URL：</strong> </p>\n<ul>\n<li><code>http://xx.com/api/user/register</code></li></ul>\n<p><strong>请求方式：</strong></p>\n<ul>\n<li>POST </li></ul>\n<p><strong>参数：</strong> </p>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">参数名</th>\n<th style=\"text-align:left\">必选</th>\n<th style=\"text-align:left\">类型</th>\n<th>说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">username</td>\n<td style=\"text-align:left\">是</td>\n<td style=\"text-align:left\">string</td>\n<td>用户名</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">password</td>\n<td style=\"text-align:left\">是</td>\n<td style=\"text-align:left\">string</td>\n<td>密码</td>\n</tr>\n<tr>\n<td style=\"text-align:left\">name</td>\n<td style=\"text-align:left\">否</td>\n<td style=\"text-align:left\">string</td>\n<td>昵称</td>\n</tr>\n</tbody>\n</table>\n<p> <strong>返回示例</strong></p>\n<pre><code>  {\n    &quot;error_code&quot;: 0,\n    &quot;data&quot;: {\n      &quot;uid&quot;: &quot;1&quot;,\n      &quot;username&quot;: &quot;12154545&quot;,\n      &quot;name&quot;: &quot;吴系挂&quot;,\n      &quot;groupid&quot;: 2 ,\n      &quot;reg_time&quot;: &quot;1436864169&quot;,\n      &quot;last_login_time&quot;: &quot;0&quot;,\n    }\n  }\n</code></pre><p> <strong>返回参数说明</strong> </p>\n<table>\n<thead>\n<tr>\n<th style=\"text-align:left\">参数名</th>\n<th style=\"text-align:left\">类型</th>\n<th>说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td style=\"text-align:left\">groupid</td>\n<td style=\"text-align:left\">int</td>\n<td>用户组id，1：超级管理员；2：普通用户</td>\n</tr>\n</tbody>\n</table>\n<p> <strong>备注</strong> </p>\n<ul>\n<li>更多返回错误代码请看首页的错误代码描述</li></ul>\n<p>欢迎使用wwDoc</p>\n', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '29dfc04dd2bd47a3b49cd6f0a73726ca', '2020-03-17 18:44:35', 'admin', 1, 2, 1, 1);

-- ----------------------------
-- Table structure for api_article
-- ----------------------------
DROP TABLE IF EXISTS `api_article`;
CREATE TABLE `api_article`  (
  `article_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章主键id',
  `article_title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文章标题',
  `project_id` int(11) NULL DEFAULT NULL COMMENT '所属项目id',
  `category_id` int(11) NULL DEFAULT NULL COMMENT '所属分类id',
  `despection` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文章描述',
  `get_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求地址',
  `get_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求类型',
  `get_param` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求参数',
  `return_context` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '返回实例',
  `return_param` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '返回参数说明',
  `remark` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '文章备注',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  `create_user` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发布人',
  `create_id` int(11) NULL DEFAULT NULL COMMENT '发布人id',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_user` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_id` int(11) NULL DEFAULT NULL COMMENT '更新人id',
  `version` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '版本号',
  `is_del` int(11) NULL DEFAULT NULL COMMENT '是否删除，0可用，1已删除',
  PRIMARY KEY (`article_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章详情表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of api_article
-- ----------------------------

-- ----------------------------
-- Table structure for api_category
-- ----------------------------
DROP TABLE IF EXISTS `api_category`;
CREATE TABLE `api_category`  (
  `category_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章分类主键id',
  `project_id` int(11) NULL DEFAULT NULL COMMENT '项目id',
  `category_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '上级目录',
  `icon` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图标',
  `sort` int(11) NULL DEFAULT 99 COMMENT '排序号，逆序',
  `level` int(11) NULL DEFAULT 1 COMMENT '菜单级别',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '路径地址',
  `create_id` int(10) NULL DEFAULT NULL COMMENT '创建人id',
  `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` int(10) NULL DEFAULT NULL COMMENT '更新人id',
  `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人name',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of api_category
-- ----------------------------
INSERT INTO `api_category` VALUES (19, 1, '用户模块', 0, NULL, 10, 1, NULL, 1, 'admin', '2020-03-15 16:24:00', NULL, NULL, NULL);
INSERT INTO `api_category` VALUES (20, 1, '用户登录', 19, NULL, 1, 1, NULL, 1, 'admin', '2020-03-15 16:24:30', NULL, NULL, NULL);
INSERT INTO `api_category` VALUES (21, 1, '商城', 0, NULL, 20, 1, '/apidetail/apiView?apiId=31', 1, 'admin', '2020-03-15 16:51:51', NULL, NULL, NULL);
INSERT INTO `api_category` VALUES (22, 1, '线路', 0, NULL, 30, 1, NULL, 1, 'admin', '2020-03-15 16:52:17', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for api_config
-- ----------------------------
DROP TABLE IF EXISTS `api_config`;
CREATE TABLE `api_config`  (
  `config_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_user` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '参数配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of api_config
-- ----------------------------
INSERT INTO `api_config` VALUES (1, '页面模板', 'thyme', 'views', 'Y', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', 'layuimini');
INSERT INTO `api_config` VALUES (2, '缓存清理路径', 'clearUrl', 'layuimini/api/clear.json', 'Y', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '初始化密码 123456');
INSERT INTO `api_config` VALUES (3, '站点介绍头像', 'logoImage', 'layuimini/images/logo.png', 'Y', 'admin', '2018-03-16 11:33:00', 'admin', '2020-03-05 13:39:01', 'LOGO');
INSERT INTO `api_config` VALUES (7, '站点介绍个人简介', 'site.person.desc', '90后少年，热爱写bug，热爱编程，热爱学习，分享一些个人经验，共同学习，少走弯路。Talk is cheap, show me the code!', 'Y', 'admin', '2018-03-16 11:33:00', 'admin', '2020-03-10 10:00:49', NULL);
INSERT INTO `api_config` VALUES (8, '系统首页title', 'blog.index.title', '葡萄博客', 'Y', 'admin', '2018-03-16 11:33:00', 'admin', '2020-03-10 10:42:51', NULL);
INSERT INTO `api_config` VALUES (9, '系统首页description', 'blog.index.description', '葡萄cms,极简的Java版内容管理系统。葡萄博客,个人博客网站，技术交流，经验分享。', 'Y', 'admin', '2018-03-16 11:33:00', 'admin', '2020-03-10 10:42:45', NULL);
INSERT INTO `api_config` VALUES (10, '系统首页keywords', 'blog.index.keywords', '葡萄cms,葡萄博客,Java,JavaScript,Spring,SpringBoot,Vue', 'Y', 'admin', '2018-03-16 11:33:00', 'admin', '2020-03-10 10:42:41', NULL);
INSERT INTO `api_config` VALUES (12, '站点名称', 'site.name', '葡萄内容管理系统', 'Y', 'admin', '2018-03-16 11:33:00', 'admin', '2019-10-10 13:41:12', NULL);
INSERT INTO `api_config` VALUES (13, '站点备案号', 'site.beian', '鲁ICP备19006478号-1', 'Y', 'admin', '2018-03-16 11:33:00', 'admin', '2019-10-10 13:41:12', NULL);
INSERT INTO `api_config` VALUES (14, '博客主题', 'blog.theme', 'avatar', 'Y', 'admin', '2018-03-16 11:33:00', 'admin', '2019-10-10 13:41:12', 'avatar/pnews/pblog');

-- ----------------------------
-- Table structure for api_help
-- ----------------------------
DROP TABLE IF EXISTS `api_help`;
CREATE TABLE `api_help`  (
  `help_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '帮助主键',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '内容',
  `create_id` int(11) NULL DEFAULT NULL COMMENT '创建人id',
  `create_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作者name',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `state` int(2) NULL DEFAULT 1 COMMENT '状态，1启用，0删除',
  PRIMARY KEY (`help_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of api_help
-- ----------------------------
INSERT INTO `api_help` VALUES (1, 'ssssssssssss', '请输入内容...sdsssssssss', 1, '系统管理员', '2020-03-07 16:41:56', NULL, 1);
INSERT INTO `api_help` VALUES (2, 'ddddddd', '', 1, '系统管理员', '2020-03-07 17:42:57', NULL, 1);
INSERT INTO `api_help` VALUES (3, 'ssssssssssss', NULL, 1, '系统管理员', '2020-03-08 17:10:47', NULL, 1);
INSERT INTO `api_help` VALUES (4, 'ddddddd', NULL, 1, '系统管理员', '2020-03-08 17:23:38', NULL, 1);
INSERT INTO `api_help` VALUES (5, 'ddddddd', NULL, 1, '系统管理员', '2020-03-08 17:24:58', NULL, 1);
INSERT INTO `api_help` VALUES (6, 'sfdsfsd', NULL, 1, '系统管理员', '2020-03-08 17:28:14', NULL, 1);
INSERT INTO `api_help` VALUES (7, 'ssssssssssdadasddddddddd', '', 1, '系统管理员', '2020-03-08 17:30:12', NULL, 1);
INSERT INTO `api_help` VALUES (8, 'bbb测试', '<div><div><div><div></div><p>ssss</p>,</div><p>sssss222222</p>,</div><p>1111</p>,</div><p>222</p>,', 1, '系统管理员', '2020-03-08 17:34:21', '2020-03-08 18:19:06', 1);
INSERT INTO `api_help` VALUES (9, '404', '<div></div><p>333</p>,', 1, '系统管理员', '2020-03-08 18:14:32', '2020-03-08 18:19:14', 1);

-- ----------------------------
-- Table structure for api_log
-- ----------------------------
DROP TABLE IF EXISTS `api_log`;
CREATE TABLE `api_log`  (
  `log_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志主键id',
  `log_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '日志类型',
  `log_user_id` int(11) NULL DEFAULT NULL COMMENT '操作人id',
  `log_ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作人ip',
  `log_date` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  `log_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作内容',
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 195 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of api_log
-- ----------------------------
INSERT INTO `api_log` VALUES (3, 'select', 1, '192.168.20.1', '2020-03-07 13:21:56', '登录');
INSERT INTO `api_log` VALUES (4, 'select', 1, '192.168.20.1', '2020-03-07 13:53:01', '登录');
INSERT INTO `api_log` VALUES (5, 'select', 1, '192.168.20.1', '2020-03-07 14:25:08', '登录');
INSERT INTO `api_log` VALUES (6, 'select', 1, '192.168.20.1', '2020-03-07 14:29:19', '登录');
INSERT INTO `api_log` VALUES (7, 'select', 1, '192.168.20.1', '2020-03-07 14:37:01', '登录');
INSERT INTO `api_log` VALUES (8, 'select', 1, '192.168.20.1', '2020-03-07 14:51:39', '登录');
INSERT INTO `api_log` VALUES (9, 'select', 1, '192.168.20.1', '2020-03-07 15:53:31', '登录');
INSERT INTO `api_log` VALUES (10, 'select', 1, '192.168.20.1', '2020-03-07 15:56:45', '登录');
INSERT INTO `api_log` VALUES (11, 'select', 1, '192.168.20.1', '2020-03-07 16:00:10', '登录');
INSERT INTO `api_log` VALUES (12, 'select', 1, '192.168.20.1', '2020-03-07 16:31:20', '登录');
INSERT INTO `api_log` VALUES (13, 'select', 1, '192.168.20.1', '2020-03-07 17:49:43', '登录');
INSERT INTO `api_log` VALUES (14, 'select', 1, '192.168.20.1', '2020-03-07 17:58:13', '登录');
INSERT INTO `api_log` VALUES (15, 'select', 1, '192.168.20.1', '2020-03-07 18:01:30', '登录');
INSERT INTO `api_log` VALUES (16, 'select', 1, '192.168.20.1', '2020-03-07 18:04:36', '登录');
INSERT INTO `api_log` VALUES (17, 'select', 1, '192.168.20.1', '2020-03-08 15:30:42', '登录');
INSERT INTO `api_log` VALUES (18, 'select', 1, '192.168.20.1', '2020-03-08 16:37:47', '登录');
INSERT INTO `api_log` VALUES (19, 'select', 1, '192.168.20.1', '2020-03-08 16:46:48', '登录');
INSERT INTO `api_log` VALUES (20, 'select', 1, '192.168.20.1', '2020-03-08 16:57:30', '登录');
INSERT INTO `api_log` VALUES (21, 'select', 1, '192.168.20.1', '2020-03-08 17:08:46', '登录');
INSERT INTO `api_log` VALUES (22, 'select', 1, '192.168.20.1', '2020-03-08 17:20:28', '登录');
INSERT INTO `api_log` VALUES (23, 'select', 1, '192.168.20.1', '2020-03-08 17:23:16', '登录');
INSERT INTO `api_log` VALUES (24, 'select', 1, '192.168.20.1', '2020-03-08 17:37:37', '登录');
INSERT INTO `api_log` VALUES (25, 'select', 1, '192.168.20.1', '2020-03-08 17:44:57', '登录');
INSERT INTO `api_log` VALUES (26, 'select', 1, '192.168.20.1', '2020-03-08 18:07:49', '登录');
INSERT INTO `api_log` VALUES (27, 'select', 1, '192.168.20.1', '2020-03-08 18:48:44', '登录');
INSERT INTO `api_log` VALUES (28, 'select', 1, '192.168.20.1', '2020-03-08 19:21:18', '登录');
INSERT INTO `api_log` VALUES (29, 'select', 1, '192.168.20.1', '2020-03-08 19:32:42', '登录');
INSERT INTO `api_log` VALUES (30, 'select', 1, '192.168.20.1', '2020-03-08 20:13:35', '登录');
INSERT INTO `api_log` VALUES (31, 'del', 1, '192.168.20.1', '2020-03-09 09:21:23', '删除配置');
INSERT INTO `api_log` VALUES (32, 'del', 1, '192.168.20.1', '2020-03-09 09:21:47', '删除配置');
INSERT INTO `api_log` VALUES (33, 'select', 1, '192.168.20.1', '2020-03-09 10:14:37', '登录');
INSERT INTO `api_log` VALUES (34, 'select', 1, '192.168.20.1', '2020-03-09 10:40:51', '登录');
INSERT INTO `api_log` VALUES (35, 'select', 1, '192.168.20.1', '2020-03-09 10:49:11', '登录');
INSERT INTO `api_log` VALUES (36, 'select', 1, '192.168.20.1', '2020-03-09 11:14:22', '登录');
INSERT INTO `api_log` VALUES (37, 'select', 1, '192.168.20.1', '2020-03-09 11:16:51', '登录');
INSERT INTO `api_log` VALUES (38, 'select', 1, '192.168.20.1', '2020-03-09 13:01:20', '登录');
INSERT INTO `api_log` VALUES (39, 'exit', NULL, '192.168.20.1', '2020-03-09 13:17:34', '退出登录');
INSERT INTO `api_log` VALUES (40, 'select', 1, '192.168.20.1', '2020-03-09 13:18:52', '登录');
INSERT INTO `api_log` VALUES (41, 'select', 1, '192.168.20.1', '2020-03-09 13:30:47', '登录');
INSERT INTO `api_log` VALUES (42, 'select', 1, '192.168.20.1', '2020-03-09 13:33:21', '登录');
INSERT INTO `api_log` VALUES (43, 'select', 1, '192.168.20.1', '2020-03-09 13:35:15', '登录');
INSERT INTO `api_log` VALUES (44, 'exit', NULL, '192.168.20.1', '2020-03-09 13:36:39', '退出登录');
INSERT INTO `api_log` VALUES (45, 'select', 1, '192.168.20.1', '2020-03-09 13:36:43', '登录');
INSERT INTO `api_log` VALUES (46, 'select', 1, '192.168.20.1', '2020-03-09 13:45:03', '登录');
INSERT INTO `api_log` VALUES (47, 'exit', NULL, '192.168.20.1', '2020-03-09 13:45:09', '退出登录');
INSERT INTO `api_log` VALUES (48, 'select', 1, '192.168.20.1', '2020-03-09 14:09:48', '登录');
INSERT INTO `api_log` VALUES (49, 'select', 3, '192.168.20.1', '2020-03-09 14:14:08', '登录');
INSERT INTO `api_log` VALUES (50, 'add', 3, '192.168.20.1', '2020-03-09 14:21:35', '添加/更新团队信息');
INSERT INTO `api_log` VALUES (51, 'add', 3, '192.168.20.1', '2020-03-09 14:26:06', '添加团队成员');
INSERT INTO `api_log` VALUES (52, 'exit', NULL, '192.168.20.1', '2020-03-09 14:26:22', '退出登录');
INSERT INTO `api_log` VALUES (53, 'select', 1, '192.168.20.1', '2020-03-09 14:26:31', '登录');
INSERT INTO `api_log` VALUES (54, 'exit', NULL, '192.168.20.1', '2020-03-09 14:28:02', '退出登录');
INSERT INTO `api_log` VALUES (55, 'select', 4, '192.168.20.1', '2020-03-09 14:28:37', '登录');
INSERT INTO `api_log` VALUES (56, 'add', 4, '192.168.20.1', '2020-03-09 14:30:08', '添加/更新团队信息');
INSERT INTO `api_log` VALUES (57, 'add', 4, '192.168.20.1', '2020-03-09 14:30:17', '添加团队成员');
INSERT INTO `api_log` VALUES (58, 'add', 4, '192.168.20.1', '2020-03-09 14:30:20', '添加团队成员');
INSERT INTO `api_log` VALUES (59, 'add', 4, '192.168.20.1', '2020-03-09 14:32:33', '添加团队成员');
INSERT INTO `api_log` VALUES (60, 'add', 4, '192.168.20.1', '2020-03-09 14:32:36', '添加团队成员');
INSERT INTO `api_log` VALUES (61, 'select', 4, '192.168.20.1', '2020-03-09 15:00:29', '登录');
INSERT INTO `api_log` VALUES (62, 'add', 4, '192.168.20.1', '2020-03-09 15:00:41', '添加团队成员');
INSERT INTO `api_log` VALUES (63, 'add', 4, '192.168.20.1', '2020-03-09 15:02:51', '添加团队成员');
INSERT INTO `api_log` VALUES (64, 'select', 4, '192.168.20.1', '2020-03-09 15:15:58', '登录');
INSERT INTO `api_log` VALUES (65, 'add', 4, '192.168.20.1', '2020-03-09 15:16:08', '添加团队成员');
INSERT INTO `api_log` VALUES (66, 'add', 4, '192.168.20.1', '2020-03-09 15:16:10', '添加团队成员');
INSERT INTO `api_log` VALUES (67, 'add', 4, '192.168.20.1', '2020-03-09 15:16:16', '添加团队成员');
INSERT INTO `api_log` VALUES (68, 'select', 4, '192.168.20.1', '2020-03-09 18:05:16', '登录');
INSERT INTO `api_log` VALUES (69, 'exit', NULL, '192.168.20.1', '2020-03-09 18:06:16', '退出登录');
INSERT INTO `api_log` VALUES (70, 'select', 1, '192.168.20.1', '2020-03-09 18:06:21', '登录');
INSERT INTO `api_log` VALUES (71, 'select', 1, '192.168.20.1', '2020-03-09 18:07:12', '登录');
INSERT INTO `api_log` VALUES (72, 'exit', NULL, '192.168.20.1', '2020-03-09 18:09:17', '退出登录');
INSERT INTO `api_log` VALUES (73, 'select', 1, '192.168.20.1', '2020-03-09 18:09:21', '登录');
INSERT INTO `api_log` VALUES (74, 'select', 1, '192.168.20.1', '2020-03-09 18:42:27', '登录');
INSERT INTO `api_log` VALUES (75, 'select', 1, '192.168.20.1', '2020-03-09 18:44:35', '登录');
INSERT INTO `api_log` VALUES (76, 'select', 1, '192.168.20.1', '2020-03-09 18:46:13', '登录');
INSERT INTO `api_log` VALUES (77, 'select', 1, '192.168.20.1', '2020-03-09 18:53:35', '登录');
INSERT INTO `api_log` VALUES (78, 'add', 1, '192.168.20.1', '2020-03-09 18:54:50', '添加/更新团队信息');
INSERT INTO `api_log` VALUES (79, 'add', 1, '192.168.20.1', '2020-03-09 20:52:29', '添加/更新团队信息');
INSERT INTO `api_log` VALUES (80, 'del', 1, '192.168.20.1', '2020-03-10 09:52:38', '删除团队成员');
INSERT INTO `api_log` VALUES (81, 'select', 1, '192.168.20.1', '2020-03-10 09:53:24', '登录');
INSERT INTO `api_log` VALUES (82, 'del', 1, '192.168.20.1', '2020-03-10 09:53:34', '删除团队成员');
INSERT INTO `api_log` VALUES (83, 'del', 1, '192.168.20.1', '2020-03-10 09:54:58', '删除团队成员');
INSERT INTO `api_log` VALUES (84, 'add', 1, '192.168.20.1', '2020-03-10 09:55:28', '添加团队成员');
INSERT INTO `api_log` VALUES (85, 'add', 1, '192.168.20.1', '2020-03-10 09:55:56', '添加团队成员');
INSERT INTO `api_log` VALUES (86, 'select', 1, '192.168.20.1', '2020-03-10 09:59:23', '登录');
INSERT INTO `api_log` VALUES (87, 'add', 1, '192.168.20.1', '2020-03-10 10:00:49', '添加/更新配置');
INSERT INTO `api_log` VALUES (88, 'del', 1, '192.168.20.1', '2020-03-10 10:01:16', '删除配置');
INSERT INTO `api_log` VALUES (89, 'add', 1, '192.168.20.1', '2020-03-10 10:42:41', '添加/更新配置');
INSERT INTO `api_log` VALUES (90, 'add', 1, '192.168.20.1', '2020-03-10 10:42:45', '添加/更新配置');
INSERT INTO `api_log` VALUES (91, 'add', 1, '192.168.20.1', '2020-03-10 10:42:51', '添加/更新配置');
INSERT INTO `api_log` VALUES (92, 'select', 1, '192.168.20.1', '2020-03-10 11:22:57', '登录');
INSERT INTO `api_log` VALUES (93, 'select', 1, '192.168.20.1', '2020-03-10 13:43:25', '登录');
INSERT INTO `api_log` VALUES (94, 'select', 1, '192.168.20.1', '2020-03-10 13:51:24', '登录');
INSERT INTO `api_log` VALUES (95, 'select', 1, '192.168.20.1', '2020-03-10 13:56:08', '登录');
INSERT INTO `api_log` VALUES (96, 'select', 1, '192.168.20.1', '2020-03-10 13:58:48', '登录');
INSERT INTO `api_log` VALUES (97, 'select', 5, '127.0.0.1', '2020-03-10 14:54:47', '登录');
INSERT INTO `api_log` VALUES (98, 'select', 4, '192.168.20.1', '2020-03-10 15:20:40', '登录');
INSERT INTO `api_log` VALUES (99, 'select', 1, '192.168.20.1', '2020-03-10 16:10:52', '登录');
INSERT INTO `api_log` VALUES (100, 'add', 1, '192.168.20.1', '2020-03-10 16:12:54', '添加/更新项目');
INSERT INTO `api_log` VALUES (101, 'select', 1, '192.168.20.1', '2020-03-10 16:18:53', '登录');
INSERT INTO `api_log` VALUES (102, 'select', 1, '192.168.20.1', '2020-03-11 11:27:49', '登录');
INSERT INTO `api_log` VALUES (103, 'select', 1, '127.0.0.1', '2020-03-11 13:16:38', '登录');
INSERT INTO `api_log` VALUES (104, 'select', 1, '127.0.0.1', '2020-03-11 13:17:22', '登录');
INSERT INTO `api_log` VALUES (105, 'select', 1, '127.0.0.1', '2020-03-11 15:22:23', '登录');
INSERT INTO `api_log` VALUES (106, 'select', 1, '192.168.20.1', '2020-03-12 13:27:56', '登录');
INSERT INTO `api_log` VALUES (107, 'add', 1, '192.168.20.1', '2020-03-12 13:32:58', '添加API');
INSERT INTO `api_log` VALUES (108, 'add', 1, '192.168.20.1', '2020-03-12 13:33:10', '添加API');
INSERT INTO `api_log` VALUES (109, 'del', 1, '192.168.20.1', '2020-03-12 13:37:05', '删除模板');
INSERT INTO `api_log` VALUES (110, 'select', 1, '192.168.20.1', '2020-03-12 14:00:40', '登录');
INSERT INTO `api_log` VALUES (111, 'add', 1, '192.168.20.1', '2020-03-12 14:01:03', '添加API');
INSERT INTO `api_log` VALUES (112, 'add', 1, '192.168.20.1', '2020-03-12 14:01:28', '创建模板');
INSERT INTO `api_log` VALUES (113, 'add', 1, '192.168.20.1', '2020-03-12 14:01:37', '添加API');
INSERT INTO `api_log` VALUES (114, 'add', 1, '192.168.20.1', '2020-03-12 14:03:46', '添加API');
INSERT INTO `api_log` VALUES (115, 'add', 1, '192.168.20.1', '2020-03-12 16:03:17', '添加API');
INSERT INTO `api_log` VALUES (116, 'select', 1, '192.168.20.1', '2020-03-13 10:05:06', '登录');
INSERT INTO `api_log` VALUES (117, 'select', 1, '192.168.20.1', '2020-03-13 17:47:39', '登录');
INSERT INTO `api_log` VALUES (118, 'add', 1, '192.168.20.1', '2020-03-13 17:48:37', '添加API');
INSERT INTO `api_log` VALUES (119, 'select', 1, '192.168.20.1', '2020-03-13 18:00:16', '登录');
INSERT INTO `api_log` VALUES (120, 'select', 1, '192.168.20.1', '2020-03-13 18:04:30', '登录');
INSERT INTO `api_log` VALUES (121, 'select', 1, '192.168.20.1', '2020-03-13 18:09:39', '登录');
INSERT INTO `api_log` VALUES (122, 'select', 1, '192.168.20.1', '2020-03-14 10:01:48', '登录');
INSERT INTO `api_log` VALUES (123, 'add', 1, '192.168.20.1', '2020-03-14 10:09:39', '添加API');
INSERT INTO `api_log` VALUES (124, 'select', 1, '192.168.20.1', '2020-03-14 13:19:31', '登录');
INSERT INTO `api_log` VALUES (125, 'export', 1, '192.168.20.1', '2020-03-14 13:20:48', '导出word');
INSERT INTO `api_log` VALUES (126, 'export', 1, '192.168.20.1', '2020-03-14 13:25:08', '导出word');
INSERT INTO `api_log` VALUES (127, 'select', 1, '192.168.20.1', '2020-03-14 13:28:40', '登录');
INSERT INTO `api_log` VALUES (128, 'export', 1, '192.168.20.1', '2020-03-14 13:28:51', '导出word');
INSERT INTO `api_log` VALUES (129, 'select', 1, '192.168.20.1', '2020-03-14 13:31:55', '登录');
INSERT INTO `api_log` VALUES (130, 'export', 1, '192.168.20.1', '2020-03-14 13:32:15', '导出word');
INSERT INTO `api_log` VALUES (131, 'select', 1, '192.168.20.1', '2020-03-14 13:36:05', '登录');
INSERT INTO `api_log` VALUES (132, 'export', 1, '192.168.20.1', '2020-03-14 13:36:14', '导出word');
INSERT INTO `api_log` VALUES (133, 'select', 1, '192.168.20.1', '2020-03-14 14:15:27', '登录');
INSERT INTO `api_log` VALUES (134, 'select', 1, '192.168.20.1', '2020-03-14 14:37:33', '登录');
INSERT INTO `api_log` VALUES (135, 'select', 1, '192.168.20.1', '2020-03-14 15:48:11', '登录');
INSERT INTO `api_log` VALUES (136, 'select', 1, '192.168.20.1', '2020-03-15 09:29:10', '登录');
INSERT INTO `api_log` VALUES (137, 'select', 1, '192.168.20.1', '2020-03-15 10:37:52', '登录');
INSERT INTO `api_log` VALUES (138, 'select', 1, '192.168.20.1', '2020-03-15 16:19:15', '登录');
INSERT INTO `api_log` VALUES (139, 'add', 1, '192.168.20.1', '2020-03-15 16:24:00', '添加/更新分类');
INSERT INTO `api_log` VALUES (140, 'add', 1, '192.168.20.1', '2020-03-15 16:24:30', '添加/更新分类');
INSERT INTO `api_log` VALUES (141, 'add', 1, '192.168.20.1', '2020-03-15 16:25:44', '添加API');
INSERT INTO `api_log` VALUES (142, 'select', 1, '192.168.20.1', '2020-03-15 16:42:51', '登录');
INSERT INTO `api_log` VALUES (143, 'add', 1, '192.168.20.1', '2020-03-15 16:44:00', '添加API');
INSERT INTO `api_log` VALUES (144, 'select', 1, '192.168.20.1', '2020-03-15 16:49:59', '登录');
INSERT INTO `api_log` VALUES (145, 'select', 1, '192.168.20.1', '2020-03-15 16:50:52', '登录');
INSERT INTO `api_log` VALUES (146, 'add', 1, '192.168.20.1', '2020-03-15 16:51:51', '添加/更新分类');
INSERT INTO `api_log` VALUES (147, 'add', 1, '192.168.20.1', '2020-03-15 16:52:17', '添加/更新分类');
INSERT INTO `api_log` VALUES (148, 'add', 1, '192.168.20.1', '2020-03-15 16:52:44', '添加API');
INSERT INTO `api_log` VALUES (149, 'del', 1, '192.168.20.1', '2020-03-15 16:53:00', '删除分类');
INSERT INTO `api_log` VALUES (150, 'del', 1, '192.168.20.1', '2020-03-15 16:53:05', '删除分类');
INSERT INTO `api_log` VALUES (151, 'del', 1, '192.168.20.1', '2020-03-15 16:53:10', '删除分类');
INSERT INTO `api_log` VALUES (152, 'del', 1, '192.168.20.1', '2020-03-15 16:53:15', '删除分类');
INSERT INTO `api_log` VALUES (153, 'del', 1, '192.168.20.1', '2020-03-15 16:53:19', '删除分类');
INSERT INTO `api_log` VALUES (154, 'del', 1, '192.168.20.1', '2020-03-15 16:53:24', '删除分类');
INSERT INTO `api_log` VALUES (155, 'del', 1, '192.168.20.1', '2020-03-15 16:53:29', '删除分类');
INSERT INTO `api_log` VALUES (156, 'del', 1, '192.168.20.1', '2020-03-15 16:54:06', '删除API');
INSERT INTO `api_log` VALUES (157, 'del', 1, '192.168.20.1', '2020-03-15 16:54:10', '删除API');
INSERT INTO `api_log` VALUES (158, 'del', 1, '192.168.20.1', '2020-03-15 16:54:13', '删除API');
INSERT INTO `api_log` VALUES (159, 'del', 1, '192.168.20.1', '2020-03-15 16:54:17', '删除API');
INSERT INTO `api_log` VALUES (160, 'del', 1, '192.168.20.1', '2020-03-15 16:54:20', '删除API');
INSERT INTO `api_log` VALUES (161, 'del', 1, '192.168.20.1', '2020-03-15 16:54:23', '删除API');
INSERT INTO `api_log` VALUES (162, 'del', 1, '192.168.20.1', '2020-03-15 16:54:26', '删除API');
INSERT INTO `api_log` VALUES (163, 'del', 1, '192.168.20.1', '2020-03-15 16:54:29', '删除API');
INSERT INTO `api_log` VALUES (164, 'del', 1, '192.168.20.1', '2020-03-15 16:54:33', '删除API');
INSERT INTO `api_log` VALUES (165, 'del', 1, '192.168.20.1', '2020-03-15 16:54:36', '删除API');
INSERT INTO `api_log` VALUES (166, 'del', 1, '192.168.20.1', '2020-03-15 16:54:45', '删除API');
INSERT INTO `api_log` VALUES (167, 'add', 1, '192.168.20.1', '2020-03-15 16:55:04', '添加API');
INSERT INTO `api_log` VALUES (168, 'del', 1, '192.168.20.1', '2020-03-15 16:56:18', '删除API');
INSERT INTO `api_log` VALUES (169, 'del', 1, '192.168.20.1', '2020-03-15 16:56:21', '删除API');
INSERT INTO `api_log` VALUES (170, 'del', 1, '192.168.20.1', '2020-03-15 16:56:25', '删除API');
INSERT INTO `api_log` VALUES (171, 'del', 1, '192.168.20.1', '2020-03-15 16:56:28', '删除API');
INSERT INTO `api_log` VALUES (172, 'add', 1, '192.168.20.1', '2020-03-15 16:56:47', '添加API');
INSERT INTO `api_log` VALUES (173, 'select', 1, '192.168.20.1', '2020-03-15 17:23:23', '登录');
INSERT INTO `api_log` VALUES (174, 'select', 1, '192.168.20.1', '2020-03-15 17:37:36', '登录');
INSERT INTO `api_log` VALUES (175, 'select', 1, '192.168.20.1', '2020-03-15 17:40:07', '登录');
INSERT INTO `api_log` VALUES (176, 'select', 1, '192.168.20.1', '2020-03-15 17:44:31', '登录');
INSERT INTO `api_log` VALUES (177, 'select', 1, '192.168.20.1', '2020-03-15 18:32:44', '登录');
INSERT INTO `api_log` VALUES (178, 'select', 1, '192.168.20.1', '2020-03-16 09:23:01', '登录');
INSERT INTO `api_log` VALUES (179, 'select', 1, '192.168.20.1', '2020-03-16 22:20:00', '登录');
INSERT INTO `api_log` VALUES (180, 'select', 1, '192.168.20.1', '2020-03-17 09:57:16', '登录');
INSERT INTO `api_log` VALUES (181, 'select', 1, '0:0:0:0:0:0:0:1', '2020-03-17 10:29:44', '登录');
INSERT INTO `api_log` VALUES (182, 'select', 1, '192.168.20.1', '2020-03-17 10:38:06', '登录');
INSERT INTO `api_log` VALUES (183, 'select', 1, '192.168.20.1', '2020-03-17 10:39:11', '登录');
INSERT INTO `api_log` VALUES (184, 'select', 1, '192.168.20.1', '2020-03-17 13:20:01', '登录');
INSERT INTO `api_log` VALUES (185, 'select', 1, '192.168.20.1', '2020-03-17 14:02:15', '登录');
INSERT INTO `api_log` VALUES (186, 'select', 1, '192.168.20.1', '2020-03-17 18:17:46', '登录');
INSERT INTO `api_log` VALUES (187, 'add/update', 1, '192.168.20.1', '2020-03-17 18:36:35', '添加/更新API');
INSERT INTO `api_log` VALUES (188, 'add/update', 1, '192.168.20.1', '2020-03-17 18:37:12', '添加/更新API');
INSERT INTO `api_log` VALUES (189, 'add/update', 1, '192.168.20.1', '2020-03-17 18:40:01', '添加/更新API');
INSERT INTO `api_log` VALUES (190, 'add/update', 1, '192.168.20.1', '2020-03-17 18:40:03', '添加/更新API');
INSERT INTO `api_log` VALUES (191, 'add/update', 1, '192.168.20.1', '2020-03-17 18:40:08', '添加/更新API');
INSERT INTO `api_log` VALUES (192, 'add/update', 1, '192.168.20.1', '2020-03-17 18:42:15', '添加/更新API');
INSERT INTO `api_log` VALUES (193, 'select', 1, '192.168.20.1', '2020-03-17 18:44:21', '登录');
INSERT INTO `api_log` VALUES (194, 'add/update', 1, '192.168.20.1', '2020-03-17 18:44:35', '添加/更新API');

-- ----------------------------
-- Table structure for api_menu
-- ----------------------------
DROP TABLE IF EXISTS `api_menu`;
CREATE TABLE `api_menu`  (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `identify` tinyint(2) NOT NULL COMMENT '标识(1主控制台,2接口平台)',
  `pid` int(11) NULL DEFAULT NULL COMMENT '父级id',
  `path` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '路径',
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'icon图标',
  `status` tinyint(1) NULL DEFAULT 1 COMMENT '状态(0隐藏,1显示)',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `perms` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `isdel` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除(1已删除,0未删除)',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of api_menu
-- ----------------------------
INSERT INTO `api_menu` VALUES (4, 1, 0, '/project/listProject', '所有项目', 'fa fa-th-large text-info', 1, 1, NULL, 0);
INSERT INTO `api_menu` VALUES (5, 1, 0, '/apps', '应用管理', 'fa fa-tasks text-green', 0, 11, NULL, 0);
INSERT INTO `api_menu` VALUES (6, 1, 0, '', '团队管理', 'fa fa-group text-warning', 1, 2, NULL, 0);
INSERT INTO `api_menu` VALUES (7, 1, 0, '', '消息通知', 'fa fa-envelope text-info', 0, 5, NULL, 0);
INSERT INTO `api_menu` VALUES (8, 1, 0, '', '系统公告', 'fa fa-bullhorn', 1, 4, NULL, 0);
INSERT INTO `api_menu` VALUES (9, 1, 0, '/log/toLogList', '操作日志', 'fa fa-tags text-muted', 1, 3, NULL, 0);
INSERT INTO `api_menu` VALUES (10, 1, 0, '', '系统设置', 'fa fa-gears text-navy', 1, 2, NULL, 0);
INSERT INTO `api_menu` VALUES (11, 1, 6, '/team/toTeamList', '我的团队', NULL, 1, 1, NULL, 0);
INSERT INTO `api_menu` VALUES (12, 1, 6, '/teamMember/toJoinList', '我的加入', NULL, 1, 1, NULL, 0);
INSERT INTO `api_menu` VALUES (13, 1, 0, '/bug/toBug', '问题反馈', 'fa fa-question-circle', 1, 10, NULL, 0);
INSERT INTO `api_menu` VALUES (14, 1, 7, '/message/list', '消息列表', NULL, 1, 1, NULL, 0);
INSERT INTO `api_menu` VALUES (15, 1, 7, '', '发送消息', NULL, 1, 2, NULL, 0);
INSERT INTO `api_menu` VALUES (16, 1, 8, '/help/toHelp', '公告列表', NULL, 1, 1, NULL, 0);
INSERT INTO `api_menu` VALUES (17, 1, 8, '/help/toHelpEdit', '新增公告', NULL, 1, 2, NULL, 0);
INSERT INTO `api_menu` VALUES (18, 1, 10, '/config/toConfig', '网站设置', NULL, 1, 1, NULL, 0);
INSERT INTO `api_menu` VALUES (21, 2, 0, '/404', '控制台', 'fa fa fa-area-chart text-primary', 1, 10, NULL, 0);
INSERT INTO `api_menu` VALUES (23, 2, 0, '', 'Api 信息', 'fa fa-tasks text-muted', 1, 3, NULL, 0);
INSERT INTO `api_menu` VALUES (24, 2, 0, '/category/toCategoryList', '分类列表', 'fa fa-life-buoy text-green', 1, 4, NULL, 0);
INSERT INTO `api_menu` VALUES (25, 2, 0, '', '企业密钥', 'fa fa-chain text-warning', 0, 1, NULL, 0);
INSERT INTO `api_menu` VALUES (26, 2, 23, '/apidetail/toAPIList', 'Api 列表', NULL, 1, 1, NULL, 0);
INSERT INTO `api_menu` VALUES (27, 2, 23, '/apidetail/toApiAdd', '添加 Api', 'fa fa fa-area-chart text-primary', 1, 2, NULL, 0);
INSERT INTO `api_menu` VALUES (42, 1, 13, '/question/toQuestionAdd', '新增反馈', NULL, 1, 1, NULL, 0);
INSERT INTO `api_menu` VALUES (43, 1, 13, '/question/toQuestionList', '反馈列表', NULL, 1, 1, NULL, 0);

-- ----------------------------
-- Table structure for api_param
-- ----------------------------
DROP TABLE IF EXISTS `api_param`;
CREATE TABLE `api_param`  (
  `param_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '参数主键id',
  `param_key` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '参数标识',
  `param_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '参数名称',
  `is_choose` int(11) NULL DEFAULT NULL COMMENT '是否必选，1必选，0非必选',
  `param_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '参数类型',
  `param_desp` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '参数说明',
  PRIMARY KEY (`param_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '请求参数表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of api_param
-- ----------------------------

-- ----------------------------
-- Table structure for api_project
-- ----------------------------
DROP TABLE IF EXISTS `api_project`;
CREATE TABLE `api_project`  (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '项目表主键id',
  `pro_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `despection` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '项目描述',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '项目访问密码',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_id` int(11) NULL DEFAULT NULL COMMENT '创建人ID',
  `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人name',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_id` int(11) NULL DEFAULT NULL COMMENT '更新人id',
  `update_user` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `is_del` int(11) NULL DEFAULT 0 COMMENT '0可用，1删除',
  `is_pub` int(11) NULL DEFAULT NULL COMMENT '是否公开，0私密，1公开',
  PRIMARY KEY (`pro_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '项目管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of api_project
-- ----------------------------
INSERT INTO `api_project` VALUES (1, 'mm商城', 'Springboot开发的简约商城项目', '00000', '2020-02-07 10:59:19', 1, NULL, '2020-03-10 16:12:54', 1, 'admin', 0, 0);
INSERT INTO `api_project` VALUES (2, 'wwDoc', '在线接口文档', NULL, '2020-02-07 15:20:56', 1, NULL, NULL, NULL, NULL, 0, 1);
INSERT INTO `api_project` VALUES (14, '222', '22222', '', NULL, 1, NULL, NULL, NULL, NULL, 1, 1);
INSERT INTO `api_project` VALUES (15, 'www', 'www', 'admin123', NULL, 1, NULL, '2020-02-25 20:04:08', 1, 'admin', 0, 0);
INSERT INTO `api_project` VALUES (16, '111ererz', '1111fsdfsdfsdfds', '1111', NULL, 1, NULL, '2020-02-25 19:54:40', 1, 'admin', 1, 0);
INSERT INTO `api_project` VALUES (17, '111222', '11112222', '1111', NULL, 1, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `api_project` VALUES (18, '111333', '11113333', '11113333', NULL, 1, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `api_project` VALUES (19, '11121212', '1111212121', '1111', NULL, 1, NULL, NULL, NULL, NULL, 1, 0);

-- ----------------------------
-- Table structure for api_question
-- ----------------------------
DROP TABLE IF EXISTS `api_question`;
CREATE TABLE `api_question`  (
  `question_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '反馈主键',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '内容',
  `create_id` int(11) NULL DEFAULT NULL COMMENT '创建人id',
  `create_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作者name',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `state` int(2) NULL DEFAULT 0 COMMENT '状态，1已处理，0未处理',
  PRIMARY KEY (`question_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of api_question
-- ----------------------------
INSERT INTO `api_question` VALUES (10, '404', '', 1, '系统管理员', '2020-03-10 11:25:57', 0);
INSERT INTO `api_question` VALUES (11, 'bbb测试', '', 1, '系统管理员', '2020-03-10 13:59:18', 0);
INSERT INTO `api_question` VALUES (12, 'sss', '', 1, '系统管理员', '2020-03-10 14:05:39', 0);
INSERT INTO `api_question` VALUES (13, 'ddd', '', 1, '系统管理员', '2020-03-10 14:06:51', 0);
INSERT INTO `api_question` VALUES (14, 'ssdsd', NULL, 1, '系统管理员', '2020-03-10 14:08:05', 0);
INSERT INTO `api_question` VALUES (15, 'sss', '', 1, '系统管理员', '2020-03-10 14:10:01', 0);
INSERT INTO `api_question` VALUES (16, NULL, NULL, 1, '系统管理员', '2020-03-10 14:38:45', 0);
INSERT INTO `api_question` VALUES (17, 'ssdsd', '<p>请输入您要反馈的问题详情</p><p><br></p>', 1, '系统管理员', '2020-03-10 14:40:21', 0);

-- ----------------------------
-- Table structure for api_team
-- ----------------------------
DROP TABLE IF EXISTS `api_team`;
CREATE TABLE `api_team`  (
  `team_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '团队主键id',
  `team_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '团队名称',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '团队介绍',
  `create_id` int(11) NULL DEFAULT NULL COMMENT '创建人id',
  `create_user` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人name',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`team_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '团队主表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of api_team
-- ----------------------------
INSERT INTO `api_team` VALUES (1, '梦之队', '梦之队梦之队梦之队梦之队梦之队', 1, 'admin', '2020-03-05 18:43:02');
INSERT INTO `api_team` VALUES (2, '海阔天空', 'editTeam', 3, 'super', '2020-03-09 14:21:35');
INSERT INTO `api_team` VALUES (3, '333', '333', 4, '333', '2020-03-09 14:30:08');
INSERT INTO `api_team` VALUES (4, '333', 'www', 1, 'admin', '2020-03-09 18:54:50');
INSERT INTO `api_team` VALUES (5, '海阔天空', 'ww', 1, 'admin', '2020-03-09 20:52:29');

-- ----------------------------
-- Table structure for api_team_member
-- ----------------------------
DROP TABLE IF EXISTS `api_team_member`;
CREATE TABLE `api_team_member`  (
  `team_member_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '团队成员主键id',
  `team_id` int(11) NULL DEFAULT NULL COMMENT '团队id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '成员id',
  `user_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '成员name',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `is_edit` int(2) NULL DEFAULT NULL COMMENT '权限 1编辑， 0只读',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`team_member_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '团队成员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of api_team_member
-- ----------------------------
INSERT INTO `api_team_member` VALUES (5, 2, 1, 'admin', '系统管理员', 1, '2020-03-09 14:26:05', NULL);
INSERT INTO `api_team_member` VALUES (6, 3, 3, 'super', '222', 1, '2020-03-09 15:16:16', NULL);
INSERT INTO `api_team_member` VALUES (7, 4, 4, '333', '333', 1, '2020-03-10 09:55:28', NULL);
INSERT INTO `api_team_member` VALUES (8, 1, 1, 'admin', '系统管理员', 1, '2020-03-10 09:55:56', NULL);

-- ----------------------------
-- Table structure for api_team_pro
-- ----------------------------
DROP TABLE IF EXISTS `api_team_pro`;
CREATE TABLE `api_team_pro`  (
  `team_pro_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '团队项目关联表主键id',
  `team_id` int(11) NULL DEFAULT NULL COMMENT '团队主键id',
  `project_id` int(11) NULL DEFAULT NULL COMMENT '项目主键id',
  `project_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '项目name',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`team_pro_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '团队项目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of api_team_pro
-- ----------------------------
INSERT INTO `api_team_pro` VALUES (1, 1, 1, '户二代', '2020-03-06 15:06:39', NULL);

-- ----------------------------
-- Table structure for api_team_pro_member
-- ----------------------------
DROP TABLE IF EXISTS `api_team_pro_member`;
CREATE TABLE `api_team_pro_member`  (
  `team_member_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '团队成员表主键id',
  `team_id` int(11) NULL DEFAULT NULL COMMENT '团队id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `project_id` int(11) NULL DEFAULT NULL COMMENT '项目id',
  `user_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '成员用户名',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`team_member_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '团队项目成员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of api_team_pro_member
-- ----------------------------

-- ----------------------------
-- Table structure for api_template
-- ----------------------------
DROP TABLE IF EXISTS `api_template`;
CREATE TABLE `api_template`  (
  `template_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '模板主键id',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模板标题',
  `context` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '内容',
  `create_user` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人name',
  `create_id` int(11) NULL DEFAULT NULL COMMENT '创建人id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`template_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '自定模板表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of api_template
-- ----------------------------
INSERT INTO `api_template` VALUES (1, 'API接口模板', '    \r\n**简要描述：** \r\n\r\n- 用户注册接口\r\n\r\n**请求URL：** \r\n- ` http://xx.com/api/user/register `\r\n  \r\n**请求方式：**\r\n- POST \r\n\r\n**参数：** \r\n\r\n|参数名|必选|类型|说明|\r\n|:----    |:---|:----- |-----   |\r\n|username |是  |string |用户名   |\r\n|password |是  |string | 密码    |\r\n|name     |否  |string | 昵称    |\r\n\r\n **返回示例**\r\n\r\n``` \r\n  {\r\n    \"error_code\": 0,\r\n    \"data\": {\r\n      \"uid\": \"1\",\r\n      \"username\": \"12154545\",\r\n      \"name\": \"吴系挂\",\r\n      \"groupid\": 2 ,\r\n      \"reg_time\": \"1436864169\",\r\n      \"last_login_time\": \"0\",\r\n    }\r\n  }\r\n```\r\n\r\n **返回参数说明** \r\n\r\n|参数名|类型|说明|\r\n|:-----  |:-----|-----                           |\r\n|groupid |int   |用户组id，1：超级管理员；2：普通用户  |\r\n\r\n **备注** \r\n\r\n- 更多返回错误代码请看首页的错误代码描述\r\n\r\n\r\n', 'admin', 0, '2020-03-02 16:53:31');
INSERT INTO `api_template` VALUES (2, '数据字典模板', '\r\n    \r\n-  用户表，储存用户信息\r\n\r\n|字段|类型|空|默认|注释|\r\n|:----    |:-------    |:--- |-- -|------      |\r\n|uid    |int(10)     |否 |  |             |\r\n|username |varchar(20) |否 |    |   用户名  |\r\n|password |varchar(50) |否   |    |   密码    |\r\n|name     |varchar(15) |是   |    |    昵称     |\r\n|reg_time |int(11)     |否   | 0  |   注册时间  |\r\n\r\n- 备注：无\r\n\r\n\r\n', 'admin', 0, '2020-03-02 18:02:26');
INSERT INTO `api_template` VALUES (13, 'sss', '', 'admin', 1, '2020-03-02 18:17:26');
INSERT INTO `api_template` VALUES (14, 'bbb测试', '', 'admin', 1, '2020-03-02 18:19:28');
INSERT INTO `api_template` VALUES (15, 'qqqq', '', 'admin', 1, '2020-03-02 18:21:45');
INSERT INTO `api_template` VALUES (16, '444', '\n    \n-  用户表，储存用户信息\n\n|字段|类型|空|默认|注释|\n|:----    |:-------    |:--- |-- -|------      |\n|uid    |int(10)     |否 |  |             |\n|username |varchar(20) |否 |    |   用户名  |\n|password |varchar(50) |否   |    |   密码    |\n|name     |varchar(15) |是   |    |    昵称     |\n|reg_time |int(11)     |否   | 0  |   注册时间  |\n\n- 备注：无\n\n\n    \n**简要描述：** \n\n- 用户注册接口\n\n**请求URL：** \n- ` http://xx.com/api/user/register `\n  \n**请求方式：**\n- POST \n\n**参数：** \n\n|参数名|必选|类型|说明|\n|:----    |:---|:----- |-----   |\n|username |是  |string |用户名   |\n|password |是  |string | 密码    |\n|name     |否  |string | 昵称    |\n\n **返回示例**\n\n``` \n  {\n    \"error_code\": 0,\n    \"data\": {\n      \"uid\": \"1\",\n      \"username\": \"12154545\",\n      \"name\": \"吴系挂\",\n      \"groupid\": 2 ,\n      \"reg_time\": \"1436864169\",\n      \"last_login_time\": \"0\",\n    }\n  }\n```\n\n **返回参数说明** \n\n|参数名|类型|说明|\n|:-----  |:-----|-----                           |\n|groupid |int   |用户组id，1：超级管理员；2：普通用户  |\n\n **备注** \n\n- 更多返回错误代码请看首页的错误代码描述\n\n\n欢迎使用wwDoc', 'admin', 1, '2020-03-12 14:01:28');

-- ----------------------------
-- Table structure for api_upload_file
-- ----------------------------
DROP TABLE IF EXISTS `api_upload_file`;
CREATE TABLE `api_upload_file`  (
  `file_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件主键id',
  `sign` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件签名标识',
  `display_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件名',
  `file_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件类型',
  `file_size` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件大小',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `pro_id` int(11) NULL DEFAULT NULL COMMENT '项目id',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件请求路径',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`file_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of api_upload_file
-- ----------------------------

-- ----------------------------
-- Table structure for api_user
-- ----------------------------
DROP TABLE IF EXISTS `api_user`;
CREATE TABLE `api_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键id',
  `user_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `head_image` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录密码',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `register_time` datetime(0) NULL DEFAULT NULL COMMENT '注册时间',
  `state` int(11) NULL DEFAULT 1 COMMENT '1启用，0禁用',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of api_user
-- ----------------------------
INSERT INTO `api_user` VALUES (1, 'admin', 'http://wwdoc.henaumcw.top/2020/03/09/10/48/48/c2987170', 'E10ADC3949BA59ABBE56E057F20F883E', '系统管理员', '1055215129@qq.com', '2020-01-31 15:25:53', 1);
INSERT INTO `api_user` VALUES (2, NULL, NULL, 'E10ADC3949BA59ABBE56E057F20F883E', '111', '105@qq.com', NULL, NULL);
INSERT INTO `api_user` VALUES (3, 'super', NULL, 'E10ADC3949BA59ABBE56E057F20F883E', '222', '222@qq.com', '2020-03-09 14:14:02', 1);
INSERT INTO `api_user` VALUES (4, '333', NULL, 'E10ADC3949BA59ABBE56E057F20F883E', '333', '333@qq.com', '2020-03-09 14:28:31', 1);
INSERT INTO `api_user` VALUES (5, 'test', NULL, '098F6BCD4621D373CADE4E832627B4F6', 'test', 'test@test.test', '2020-03-10 14:54:35', 1);

SET FOREIGN_KEY_CHECKS = 1;
