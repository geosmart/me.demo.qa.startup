//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.07.10 at 11:23:28 PM CST 
//


package me.demo.qa.startup.entity.xsd.geocoding;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}location"/>
 *         &lt;element ref="{}formatted_address"/>
 *         &lt;element ref="{}business"/>
 *         &lt;element ref="{}addressComponent"/>
 *         &lt;element ref="{}cityCode"/>
 *         &lt;element ref="{}pois"/>
 *         &lt;element ref="{}poiRegions"/>
 *         &lt;element ref="{}sematic_description"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "location",
    "formattedAddress",
    "business",
    "addressComponent",
    "cityCode",
    "pois",
    "poiRegions",
    "sematicDescription"
})
@XmlRootElement(name = "result")
public class Result {

    @XmlElement(required = true)
    protected Location location;
    @XmlElement(name = "formatted_address", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String formattedAddress;
    @XmlElement(required = true)
    protected String business;
    @XmlElement(required = true)
    protected AddressComponent addressComponent;
    @XmlElement(required = true)
    protected BigInteger cityCode;
    @XmlElement(required = true)
    protected Pois pois;
    @XmlElement(required = true)
    protected PoiRegions poiRegions;
    @XmlElement(name = "sematic_description", required = true)
    protected String sematicDescription;

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link Location }
     *     
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link Location }
     *     
     */
    public void setLocation(Location value) {
        this.location = value;
    }

    /**
     * Gets the value of the formattedAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormattedAddress() {
        return formattedAddress;
    }

    /**
     * Sets the value of the formattedAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormattedAddress(String value) {
        this.formattedAddress = value;
    }

    /**
     * Gets the value of the business property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusiness() {
        return business;
    }

    /**
     * Sets the value of the business property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusiness(String value) {
        this.business = value;
    }

    /**
     * Gets the value of the addressComponent property.
     * 
     * @return
     *     possible object is
     *     {@link AddressComponent }
     *     
     */
    public AddressComponent getAddressComponent() {
        return addressComponent;
    }

    /**
     * Sets the value of the addressComponent property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressComponent }
     *     
     */
    public void setAddressComponent(AddressComponent value) {
        this.addressComponent = value;
    }

    /**
     * Gets the value of the cityCode property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCityCode() {
        return cityCode;
    }

    /**
     * Sets the value of the cityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCityCode(BigInteger value) {
        this.cityCode = value;
    }

    /**
     * Gets the value of the pois property.
     * 
     * @return
     *     possible object is
     *     {@link Pois }
     *     
     */
    public Pois getPois() {
        return pois;
    }

    /**
     * Sets the value of the pois property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pois }
     *     
     */
    public void setPois(Pois value) {
        this.pois = value;
    }

    /**
     * Gets the value of the poiRegions property.
     * 
     * @return
     *     possible object is
     *     {@link PoiRegions }
     *     
     */
    public PoiRegions getPoiRegions() {
        return poiRegions;
    }

    /**
     * Sets the value of the poiRegions property.
     * 
     * @param value
     *     allowed object is
     *     {@link PoiRegions }
     *     
     */
    public void setPoiRegions(PoiRegions value) {
        this.poiRegions = value;
    }

    /**
     * Gets the value of the sematicDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSematicDescription() {
        return sematicDescription;
    }

    /**
     * Sets the value of the sematicDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSematicDescription(String value) {
        this.sematicDescription = value;
    }

}
