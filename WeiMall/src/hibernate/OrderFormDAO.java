package hibernate;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * OrderForm entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate.OrderForm
 * @author MyEclipse Persistence Tools
 */

public class OrderFormDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(OrderFormDAO.class);
	// property constants
	public static final String BUYER_USERNAME = "buyerUsername";
	public static final String SELLER_USERNAME = "sellerUsername";
	public static final String ORDER_STATE = "orderState";
	public static final String CONSIGNEE_INFO_ID = "consigneeInfoId";
	public static final String ORDER_PAYMENT_MODE = "orderPaymentMode";
	public static final String ORDER_TOTAL_PRICE = "orderTotalPrice";
	public static final String ORDER_TIME = "orderTime";
	public static final String GOODS_ID_LIST = "goodsIdList";
	public static final String GOODS_NUM_LIST = "goodsNumList";
	public static final String ORDER_SALE_INFO = "orderSaleInfo";
	public static final String ORDER_GOODS_STANDARD1 = "orderGoodsStandard1";
	public static final String ORDER_GOODS_STANDARD2 = "orderGoodsStandard2";

	public void save(OrderForm transientInstance) {
		log.debug("saving OrderForm instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(OrderForm persistentInstance) {
		log.debug("deleting OrderForm instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OrderForm findById(java.lang.Integer id) {
		log.debug("getting OrderForm instance with id: " + id);
		try {
			OrderForm instance = (OrderForm) getSession().get(
					"hibernate.OrderForm", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(OrderForm instance) {
		log.debug("finding OrderForm instance by example");
		try {
			List results = getSession().createCriteria("hibernate.OrderForm")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding OrderForm instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from OrderForm as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBuyerUsername(Object buyerUsername) {
		return findByProperty(BUYER_USERNAME, buyerUsername);
	}

	public List findBySellerUsername(Object sellerUsername) {
		return findByProperty(SELLER_USERNAME, sellerUsername);
	}

	public List findByOrderState(Object orderState) {
		return findByProperty(ORDER_STATE, orderState);
	}

	public List findByConsigneeInfoId(Object consigneeInfoId) {
		return findByProperty(CONSIGNEE_INFO_ID, consigneeInfoId);
	}

	public List findByOrderPaymentMode(Object orderPaymentMode) {
		return findByProperty(ORDER_PAYMENT_MODE, orderPaymentMode);
	}

	public List findByOrderTotalPrice(Object orderTotalPrice) {
		return findByProperty(ORDER_TOTAL_PRICE, orderTotalPrice);
	}

	public List findByOrderTime(Object orderTime) {
		return findByProperty(ORDER_TIME, orderTime);
	}

	public List findByGoodsIdList(Object goodsIdList) {
		return findByProperty(GOODS_ID_LIST, goodsIdList);
	}

	public List findByGoodsNumList(Object goodsNumList) {
		return findByProperty(GOODS_NUM_LIST, goodsNumList);
	}

	public List findByOrderSaleInfo(Object orderSaleInfo) {
		return findByProperty(ORDER_SALE_INFO, orderSaleInfo);
	}

	public List findByOrderGoodsStandard1(Object orderGoodsStandard1) {
		return findByProperty(ORDER_GOODS_STANDARD1, orderGoodsStandard1);
	}

	public List findByOrderGoodsStandard2(Object orderGoodsStandard2) {
		return findByProperty(ORDER_GOODS_STANDARD2, orderGoodsStandard2);
	}

	public List findAll() {
		log.debug("finding all OrderForm instances");
		try {
			String queryString = "from OrderForm";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public OrderForm merge(OrderForm detachedInstance) {
		log.debug("merging OrderForm instance");
		try {
			OrderForm result = (OrderForm) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(OrderForm instance) {
		log.debug("attaching dirty OrderForm instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OrderForm instance) {
		log.debug("attaching clean OrderForm instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}