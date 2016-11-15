#初始化人员信息
INSERT INTO `my_schema`.`personner` (`LOGINID`, `PASSWORD`, `NAME`, `CELLNUMBER`, `EMAIL`, `STATUS`, `CREATORID`, `CREATORNAME`, `CREATETIME`) VALUES ('admin', '123456', 'admin', '18516299064', 'xwangq123@163.com', '1', '1', '初始化数据', '2016/11/15');
#页面初始化page
#权限模块
INSERT INTO `my_schema`.`page` (`ID`, `PARENTID`, `TYPE`, `PAGEID`, `NAME`, `DESCRIPTION`, `SEQUENCE`, `STATUS`) VALUES ('1', '0', '1', 'security', '权限管理', '权限模块', '0', '1');
INSERT INTO `my_schema`.`page` (`ID`, `PARENTID`, `TYPE`, `PAGEID`, `NAME`, `DESCRIPTION`, `SEQUENCE`, `STATUS`) VALUES ('101', '1', '2', 'personner', '人员管理', '人员维护', '0', '1');
INSERT INTO `my_schema`.`page` (`ID`, `PARENTID`, `TYPE`, `PAGEID`, `NAME`, `DESCRIPTION`, `SEQUENCE`, `STATUS`) VALUES ('102', '1', '2', 'role', '角色管理', '角色维护授权', '0', '1');
#功能初始化action
INSERT INTO `my_schema`.`action` (`PAGEID`, `OPERATIONUD`, `NAME`, `STATUS`) VALUES ('101', 'Common|Add', '新增', '1');
INSERT INTO `my_schema`.`action` (`PAGEID`, `OPERATIONUD`, `NAME`, `STATUS`) VALUES ('101', 'Common|Edit', '修改', '1');
INSERT INTO `my_schema`.`action` (`PAGEID`, `OPERATIONUD`, `NAME`, `STATUS`) VALUES ('101', 'Common|Abandon', '作废', '1');

INSERT INTO `my_schema`.`action` (`PAGEID`, `OPERATIONUD`, `NAME`, `STATUS`) VALUES ('102', 'Common|Add', '新增', '1');
INSERT INTO `my_schema`.`action` (`PAGEID`, `OPERATIONUD`, `NAME`, `STATUS`) VALUES ('102', 'Common|Edit', '修改', '1');
INSERT INTO `my_schema`.`action` (`PAGEID`, `OPERATIONUD`, `NAME`, `STATUS`) VALUES ('102', 'Common|PAUSE', '停用', '1');
INSERT INTO `my_schema`.`action` (`PAGEID`, `OPERATIONUD`, `NAME`, `STATUS`) VALUES ('102', 'Common|Abandon', '作废', '1');

#初始化字典项keyvalueitem
INSERT INTO `my_schema`.`keyvalueitem` (`CATEGORY`, `NAME`, `CAPTION`, `KEYID`, `VALUE`, `STATUS`) VALUES ('code', '基础数据状态', 'BaseDataStatus', '1', '有效', '1');
INSERT INTO `my_schema`.`keyvalueitem` (`CATEGORY`, `NAME`, `CAPTION`, `KEYID`, `VALUE`, `STATUS`) VALUES ('code', '基础数据状态', 'BaseDataStatus', '99', '作废', '1');

INSERT INTO `my_schema`.`keyvalueitem` (`CATEGORY`, `NAME`, `CAPTION`, `KEYID`, `VALUE`, `STATUS`) VALUES ('code', '主数据状态', 'MasterDataStatus', '1', '有效', '1');
INSERT INTO `my_schema`.`keyvalueitem` (`CATEGORY`, `NAME`, `CAPTION`, `KEYID`, `VALUE`, `STATUS`) VALUES ('code', '主数据状态', 'MasterDataStatus', '2', '停用', '1');
INSERT INTO `my_schema`.`keyvalueitem` (`CATEGORY`, `NAME`, `CAPTION`, `KEYID`, `VALUE`, `STATUS`) VALUES ('code', '主数据状态', 'MasterDataStatus', '99', '作废', '1');

INSERT INTO `my_schema`.`keyvalueitem` (`CATEGORY`, `NAME`, `CAPTION`, `KEYID`, `VALUE`, `STATUS`) VALUES ('code', '节点类型', 'CategoryType', '1', '页面', '1');
INSERT INTO `my_schema`.`keyvalueitem` (`CATEGORY`, `NAME`, `CAPTION`, `KEYID`, `VALUE`, `STATUS`) VALUES ('code', '节点类型', 'CategoryType', '2', '按钮', '1');

INSERT INTO `my_schema`.`keyvalueitem` (`CATEGORY`, `NAME`, `CAPTION`, `KEYID`, `VALUE`, `STATUS`) VALUES ('code', '页面类型', 'PageType', '1', '系统', '1');
INSERT INTO `my_schema`.`keyvalueitem` (`CATEGORY`, `NAME`, `CAPTION`, `KEYID`, `VALUE`, `STATUS`) VALUES ('code', '页面类型', 'PageType', '2', '页面', '1');

use  my_schema;
#初始化node表 每次新增page执行下面脚本
INSERT INTO Node ( CategoryType, CategoryId, Status)
SELECT  1, Id, 1
  FROM Page 
 WHERE Type = 2 AND Status = 1
   and not exists (select * from node where node.categoryid = page.Id and CategoryType=1);

-- 确保所有按钮，在Node中已存在 每次新增action执行下面脚本 先执行初始化node  page脚本 
INSERT INTO Node ( CategoryType, CategoryId, Status)
SELECT 2, Id, 1
  FROM Action 
 WHERE Status = 1
   and not exists (select * from node where node.categoryid = action.Id and CategoryType=2)
   and exists (select * from page
                WHERE Type = 2 AND Status = 1 
                  and page.id= action.Pageid);