//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.27 at 03:55:27 PM CST 
//


package me.demo.qa.startup.entity.xsd.skweather;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;attribute name="centername" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="cityX" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="cityY" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="cityname" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="fontColor" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="humidity" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="pyName" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="state1" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="state2" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="stateDetailed" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="tem1" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="tem2" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="temNow" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="time" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *       &lt;attribute name="url" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="windDir" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="windPower" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *       &lt;attribute name="windState" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "city")
public class City {

    @XmlAttribute(name = "centername", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String centername;
    @XmlAttribute(name = "cityX", required = true)
    protected BigDecimal cityX;
    @XmlAttribute(name = "cityY", required = true)
    protected BigDecimal cityY;
    @XmlAttribute(name = "cityname", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String cityname;
    @XmlAttribute(name = "fontColor", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String fontColor;
    @XmlAttribute(name = "humidity", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String humidity;
    @XmlAttribute(name = "pyName", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String pyName;
    @XmlAttribute(name = "state1", required = true)
    protected BigInteger state1;
    @XmlAttribute(name = "state2", required = true)
    protected BigInteger state2;
    @XmlAttribute(name = "stateDetailed", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String stateDetailed;
    @XmlAttribute(name = "tem1", required = true)
    protected BigInteger tem1;
    @XmlAttribute(name = "tem2", required = true)
    protected BigInteger tem2;
    @XmlAttribute(name = "temNow", required = true)
    protected BigInteger temNow;
    @XmlAttribute(name = "time", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String time;
    @XmlAttribute(name = "url", required = true)
    protected BigInteger url;
    @XmlAttribute(name = "windDir", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String windDir;
    @XmlAttribute(name = "windPower", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String windPower;
    @XmlAttribute(name = "windState", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String windState;

    /**
     * Gets the value of the centername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCentername() {
        return centername;
    }

    /**
     * Sets the value of the centername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCentername(String value) {
        this.centername = value;
    }

    /**
     * Gets the value of the cityX property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCityX() {
        return cityX;
    }

    /**
     * Sets the value of the cityX property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCityX(BigDecimal value) {
        this.cityX = value;
    }

    /**
     * Gets the value of the cityY property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCityY() {
        return cityY;
    }

    /**
     * Sets the value of the cityY property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCityY(BigDecimal value) {
        this.cityY = value;
    }

    /**
     * Gets the value of the cityname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityname() {
        return cityname;
    }

    /**
     * Sets the value of the cityname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityname(String value) {
        this.cityname = value;
    }

    /**
     * Gets the value of the fontColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFontColor() {
        return fontColor;
    }

    /**
     * Sets the value of the fontColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFontColor(String value) {
        this.fontColor = value;
    }

    /**
     * Gets the value of the humidity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHumidity() {
        return humidity;
    }

    /**
     * Sets the value of the humidity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHumidity(String value) {
        this.humidity = value;
    }

    /**
     * Gets the value of the pyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPyName() {
        return pyName;
    }

    /**
     * Sets the value of the pyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPyName(String value) {
        this.pyName = value;
    }

    /**
     * Gets the value of the state1 property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getState1() {
        return state1;
    }

    /**
     * Sets the value of the state1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setState1(BigInteger value) {
        this.state1 = value;
    }

    /**
     * Gets the value of the state2 property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getState2() {
        return state2;
    }

    /**
     * Sets the value of the state2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setState2(BigInteger value) {
        this.state2 = value;
    }

    /**
     * Gets the value of the stateDetailed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateDetailed() {
        return stateDetailed;
    }

    /**
     * Sets the value of the stateDetailed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateDetailed(String value) {
        this.stateDetailed = value;
    }

    /**
     * Gets the value of the tem1 property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTem1() {
        return tem1;
    }

    /**
     * Sets the value of the tem1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTem1(BigInteger value) {
        this.tem1 = value;
    }

    /**
     * Gets the value of the tem2 property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTem2() {
        return tem2;
    }

    /**
     * Sets the value of the tem2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTem2(BigInteger value) {
        this.tem2 = value;
    }

    /**
     * Gets the value of the temNow property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTemNow() {
        return temNow;
    }

    /**
     * Sets the value of the temNow property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTemNow(BigInteger value) {
        this.temNow = value;
    }

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTime(String value) {
        this.time = value;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setUrl(BigInteger value) {
        this.url = value;
    }

    /**
     * Gets the value of the windDir property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWindDir() {
        return windDir;
    }

    /**
     * Sets the value of the windDir property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWindDir(String value) {
        this.windDir = value;
    }

    /**
     * Gets the value of the windPower property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWindPower() {
        return windPower;
    }

    /**
     * Sets the value of the windPower property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWindPower(String value) {
        this.windPower = value;
    }

    /**
     * Gets the value of the windState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWindState() {
        return windState;
    }

    /**
     * Sets the value of the windState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWindState(String value) {
        this.windState = value;
    }

}