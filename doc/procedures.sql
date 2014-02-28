drop procedure if exists checkseller;
drop procedure if exists regseller;

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

		insert into `weimall`.`seller` (`seller_id`, `seller_name`, `seller_email`, `seller_pwd`, `seller_credit`, `seller_good_evaluation_num`, `seller_shop_level`, `seller_validity`, `seller_goods_on_sell`, `seller_total_goods_num`) VALUES (currID, username, email, password,0,0,0,0,0,0);

		set ret = currID;

	end if;

END$$