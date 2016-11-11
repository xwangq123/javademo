DROP TABLE IF EXISTS KEYVALUEITEM;
/*==============================================================*/
/* Table: KEYVALUEITEM字典项                                    */
/*==============================================================*/
CREATE TABLE KEYVALUEITEM 
(
   ID                   INTEGER                        NOT NULL  AUTO_INCREMENT,
   NAME                 VARCHAR(100)                   NULL,
   CAPTION              VARCHAR(100)                   NULL,
   KEYId                INT 	                       NULL,
   VALUE                VARCHAR(100)                   NULL,
   STATUS               INT                            NULL,
   CONSTRAINT PK_KEYVALUEITEM PRIMARY KEY (ID)
);


DROP TABLE IF EXISTS PAGE;
/*==============================================================*/
/* Table: PAGE窗体页面                                          */
/*==============================================================*/
CREATE TABLE PAGE
(
	ID					INTEGER 						NOT NULL AUTO_INCREMENT,
    PARENTID			INTEGER							NULL,
    TYPE				INTEGER 						NOT NULL,
	PAGEID				VARCHAR(50)						NULL,
	NAME				VARCHAR(50)						NULL,
    NAME_ENUS			VARCHAR(50)						NULL,
    DESCRIPTION			VARCHAR(200)					NULL,
    ICON				VARCHAR(100)					NULL,
	SEQUENCE 			INT								NOT NULL,
    STATUS				INT								NOT NULL,
	CONSTRAINT PK_PAGE PRIMARY KEY (ID)
);

