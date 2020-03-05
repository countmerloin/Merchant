package app.entities;

import app.utilities.CurrentUser;

import javax.persistence.*;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long productId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private String category;

    @Column()
    private String description;

    @Column(nullable = false)
    private Double unitPrice;

    @Column(nullable = false)
    private Long inventory;

    @Column(nullable = false)
    private String paymentOptions;

    @Column(nullable = false)
    private String shippingMethods;

    @Column(nullable = false)
    private Long merchantId;

    public Product() {}
    public Product(Long productId, String productName, String category,
                   String description, Double unitPrice, Long inventory,
                   String paymentOptions, String shippingMethods) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.description = description;
        this.unitPrice = unitPrice;
        this.inventory = inventory;
        this.paymentOptions = paymentOptions;
        this.shippingMethods = shippingMethods;
        this.merchantId = CurrentUser.get().getMerchantId();
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public Long getInventory() {
        return inventory;
    }

    public String getPaymentOptions() {
        return paymentOptions;
    }

    public String getShippingMethods() {
        return shippingMethods;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }
}
