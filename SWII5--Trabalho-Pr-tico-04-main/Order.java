package gerenciador;

import java.util.Date;

public class Order {
    private int orderNo;
    private float purchaseAmt;
    private Date orderDate;
    private String customerName;
    private String salesmanName;
	private int customerId;
	private int salesmanId;

    public Order() {
    }
    
    public Order(float purchaseAmt, Date orderDate, int customerId, int salesmanId) {
        this.purchaseAmt = purchaseAmt;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.salesmanId = salesmanId;
    }


    public Order(int orderNo, float purchaseAmt, Date orderDate, String customerName, String salesmanName) {
        this.orderNo = orderNo;
        this.purchaseAmt = purchaseAmt;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.salesmanName = salesmanName;
    }

    // Getters and Setters
    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public float getPurchaseAmt() {
        return purchaseAmt;
    }

    public void setPurchaseAmt(float purchaseAmt) {
        this.purchaseAmt = purchaseAmt;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }
    
    public int getSalesmanId() {
        return salesmanId;
    }
    
    public void setSalesmanId(int salesmanId) {
    	this.salesmanId = salesmanId;
    }
    
    public int getCustomerId() {
        return customerId;
    }
    
    public void setCustomerId(int customerId) {
    	this.customerId = customerId;
    }
}
