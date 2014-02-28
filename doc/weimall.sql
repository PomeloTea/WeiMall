drop table if exists order_form;
drop table if exists goods_info;
drop table if exists consignee_info;
drop table if exists shop;
drop table if exists buyer;
drop table if exists seller;
drop procedure if exists checkseller;
drop procedure if exists regseller;

create table seller
(
	seller_id                int,
	seller_name              varchar(20),
	seller_email             varchar(40),
	seller_pwd               varchar(20),
	seller_real_name		 varchar(20),
	seller_sex				 int,
	seller_birthday			 varchar(20),
	seller_qq				 varchar(20),
	seller_phone_num 		 varchar(20),
	seller_last_login_time	 varchar(20),
	seller_last_login_ip	 varchar(20),
	seller_credit			 int,
	seller_good_evaluation_num	int,
	seller_shop_level		 int,
	seller_validity			 varchar(20),
	seller_goods_on_sell	 int,
	seller_totol_goods_num	 int,
	primary key(seller_id)
);

create table shop
(
	shop_id					int,
	seller_id				int,
	shop_homepage_url		varchar(256),
	shop_logo				varchar(256),
	shop_QR_code			varchar(256),
	shop_latest_goods_logo	varchar(256),
	shop_recommended_goods_logo	varchar(256),
	shop_hottest_goods_logo	varchar(256),
	shop_name				varchar(40),
	shop_area				varchar(40),
	shop_address			varchar(256),
	shop_tel				varchar(20),
	shop_qq					varchar(20),
	shop_introduction		varchar(256),
	shop_homepage_AD_pic	varchar(256),
	shop_homepage_AD_url	varchar(256),
	shop_goods_types		varchar(256),
	primary key(shop_id),
	CONSTRAINT `shop_fk` FOREIGN KEY (`seller_id`) REFERENCES `seller` (`seller_id`)
);

create table buyer
(
	buyer_id				int,
	buyer_username			varchar(20),
	buyer_email				varchar(40),
	buyer_pwd				varchar(20),
	buyer_real_name			varchar(20),
	buyer_sex				int,
	buyer_birthday			varchar(20),
	buyer_qq				varchar(20),
	buyer_phone_num			varchar(20),
	buyer_credit			int,
	primary key(buyer_id)
);

create table goods_info
(
	goods_id				int,
	shop_id					int,
	goods_name				varchar(256),
	goods_price				double,
	goods_standard_1		varchar(256),
	goods_standard_2		varchar(256),
	goods_amount			int,
	goods_Art_No			varchar(40),
	goods_on_sell			int,
	goods_pic				varchar(256),
	goods_info				varchar(256),
	goods_types				varchar(256),
	shop_goods_types		varchar(256),
	primary key(goods_id),
	CONSTRAINT `goods_fk` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`shop_id`)
);

create table consignee_info
(
	consignee_id			int,
	consignee_info_name		varchar(20),
	consignee_phone			varchar(20),
	consignee_address		varchar(256),
	buyer_id				int,
	primary key(consignee_id),
	CONSTRAINT `consignee_fk` FOREIGN KEY (`buyer_id`) REFERENCES `buyer` (`buyer_id`)
);

create table order_form
(
	order_id				int,
	buyer_id				int,
	buyer_username			varchar(20),
	seller_id				int,
	seller_username			varchar(20),
	order_state				int,
	consignee_info_id		int,
	order_payment_mode		int,
	order_total_price		double,
	order_time				varchar(20),
	goods_id_list			varchar(256),
	goods_num_list			varchar(256),
	order_sale_info			varchar(20),
	order_goods_standard_1	varchar(256),
	order_goods_standard_2	varchar(256),
	primary key(order_id),
	CONSTRAINT `order_fk_1` FOREIGN KEY (`seller_id`) REFERENCES `seller` (`seller_id`),
	CONSTRAINT `order_fk_2` FOREIGN KEY (`buyer_id`) REFERENCES `buyer` (`buyer_id`)
);

DELIMITER $$


CREATE DEFINER=`root`@`localhost` PROCEDURE `checkseller`(in username varchar(40),password varchar(20),out ret int)

BEGIN
	
	declare tmp1 varchar(40);
	
	declare tmp2 varchar(40);

	declare tmp3 integer;

	set ret=-2;

	select seller_name,seller_pwd,seller_id from seller where (seller_name=username) into tmp1,tmp2,tmp3;

	if tmp1=username then set ret = tmp3;

		else select seller_email,seller_pwd from seller where (seller_email=username) into tmp1,tmp2,tmp3;
			
		if tmp1=username then set ret = tmp3;
			
		end if;

	end if;
	
	if tmp2!=password then set ret=-1;
	
	end if;

END$$

DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `regseller`(in username varchar(40),email varchar(40),password varchar(20),out ret int)

BEGIN
	
	declare tmp varchar(40);

	declare currID integer;
	set ret=0;

	select seller_name from seller where (seller_name=username) into tmp;

	if tmp=username then set ret=-2;

	end if;
	
	select seller_email from seller where (seller_email=email) into tmp;

	if tmp=email then set ret=-1;

	end if;

	set currID = (select count(*) from seller);

	if ret=0 then 

		insert into `weimall`.`seller` (`seller_id`, `seller_name`, `seller_email`, `seller_pwd`) VALUES (currID, username, email, password);

		set ret = currID;

	end if;

END$$