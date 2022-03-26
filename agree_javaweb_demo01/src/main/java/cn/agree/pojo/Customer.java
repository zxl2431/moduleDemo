package cn.agree.pojo;

public class Customer {
    private Long cust_id;
    private String cust_name;
    private String cust_source;
    private String cust_level;
    private String cust_industry;
    private String cust_address;
    private String cust_phone;

    public Customer() {
    }

    public Customer(Long cust_id, String cust_name, String cust_source, String cust_level, String cust_industry, String cust_address, String cust_phone) {
        this.cust_id = cust_id;
        this.cust_name = cust_name;
        this.cust_source = cust_source;
        this.cust_level = cust_level;
        this.cust_industry = cust_industry;
        this.cust_address = cust_address;
        this.cust_phone = cust_phone;
    }

    public Long getCust_id() {
        return cust_id;
    }

    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_source() {
        return cust_source;
    }

    public void setCust_source(String cust_source) {
        this.cust_source = cust_source;
    }

    public String getCust_level() {
        return cust_level;
    }

    public void setCust_level(String cust_level) {
        this.cust_level = cust_level;
    }

    public String getCust_industry() {
        return cust_industry;
    }

    public void setCust_industry(String cust_industry) {
        this.cust_industry = cust_industry;
    }

    public String getCust_address() {
        return cust_address;
    }

    public void setCust_address(String cust_address) {
        this.cust_address = cust_address;
    }

    public String getCust_phone() {
        return cust_phone;
    }

    public void setCust_phone(String cust_phone) {
        this.cust_phone = cust_phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cust_id=" + cust_id +
                ", cust_name='" + cust_name + '\'' +
                ", cust_source='" + cust_source + '\'' +
                ", cust_level='" + cust_level + '\'' +
                ", cust_industry='" + cust_industry + '\'' +
                ", cust_address='" + cust_address + '\'' +
                ", cust_phone='" + cust_phone + '\'' +
                '}';
    }
}
