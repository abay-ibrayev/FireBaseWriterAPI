package kz.fa.firebasewriter.model;

import java.util.Map;

/**
 * Created by abay on 1/17/17.
 */
public class FireGood {
    private String id;
    private String barcode;
    private String caption;
    private String measure;
    private String spec;
    private String goodTypeId;
    private String goodTypeCode;
    private Long changeDate;
    private String externalId;



    // pharmacy fields
    private String form;
    private String country;
    private String manufacturer;

    // each store has it's own copies
    private Double quantity;
    private String shortcode;
    private Double markup;
    private Boolean favorite;
    private Integer favOrder;
    private Map<String, Map<String, FirePrice>> prices;

    public FireGood() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getGoodTypeId() {
        return goodTypeId;
    }

    public void setGoodTypeId(String goodTypeId) {
        this.goodTypeId = goodTypeId;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getShortcode() {
        return shortcode;
    }

    public void setShortcode(String shortcode) {
        this.shortcode = shortcode;
    }

    public Double getMarkup() {
        return markup;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }
    public void setMarkup(Double markup) {
        this.markup = markup;
    }

    public Long getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Long changeDate) {
        this.changeDate = changeDate;
    }

    public Map<String, Map<String, FirePrice>> getPrices() {
        return prices;
    }

    public void setPrices(Map<String, Map<String, FirePrice>> prices) {
        this.prices = prices;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public Integer getFavOrder() {
        return favOrder;
    }

    public void setFavOrder(Integer favOrder) {
        this.favOrder = favOrder;
    }

    public String getGoodTypeCode() {
        return goodTypeCode;
    }

    public void setGoodTypeCode(String goodTypeCode) {
        this.goodTypeCode = goodTypeCode;
    }

    @Override
    public String toString() {
        return "FireGood{" +
                "id='" + id + '\'' +
                ", barcode='" + barcode + '\'' +
                ", caption='" + caption + '\'' +
                ", measure='" + measure + '\'' +
                '}';
    }
}
