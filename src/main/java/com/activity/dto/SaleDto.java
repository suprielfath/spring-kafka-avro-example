/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.activity.dto;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class SaleDto extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -1003868432739655263L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"SaleDto\",\"namespace\":\"com.activity.dto\",\"fields\":[{\"name\":\"id\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"invoiceNumber\",\"type\":\"string\"},{\"name\":\"saleDate\",\"type\":\"string\"},{\"name\":\"totalAmount\",\"type\":\"double\"},{\"name\":\"paymentStatus\",\"type\":\"string\"},{\"name\":\"customerName\",\"type\":\"string\"},{\"name\":\"saleDetailDto\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"SaleDetailDto\",\"fields\":[{\"name\":\"productId\",\"type\":\"long\"},{\"name\":\"quantity\",\"type\":\"int\"},{\"name\":\"unitPrice\",\"type\":\"double\"}]}}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<SaleDto> ENCODER =
      new BinaryMessageEncoder<SaleDto>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<SaleDto> DECODER =
      new BinaryMessageDecoder<SaleDto>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<SaleDto> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<SaleDto> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<SaleDto>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this SaleDto to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a SaleDto from a ByteBuffer. */
  public static SaleDto fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.Long id;
  @Deprecated public java.lang.CharSequence invoiceNumber;
  @Deprecated public java.lang.CharSequence saleDate;
  @Deprecated public double totalAmount;
  @Deprecated public java.lang.CharSequence paymentStatus;
  @Deprecated public java.lang.CharSequence customerName;
  @Deprecated public java.util.List<com.activity.dto.SaleDetailDto> saleDetailDto;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public SaleDto() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param invoiceNumber The new value for invoiceNumber
   * @param saleDate The new value for saleDate
   * @param totalAmount The new value for totalAmount
   * @param paymentStatus The new value for paymentStatus
   * @param customerName The new value for customerName
   * @param saleDetailDto The new value for saleDetailDto
   */
  public SaleDto(java.lang.Long id, java.lang.CharSequence invoiceNumber, java.lang.CharSequence saleDate, java.lang.Double totalAmount, java.lang.CharSequence paymentStatus, java.lang.CharSequence customerName, java.util.List<com.activity.dto.SaleDetailDto> saleDetailDto) {
    this.id = id;
    this.invoiceNumber = invoiceNumber;
    this.saleDate = saleDate;
    this.totalAmount = totalAmount;
    this.paymentStatus = paymentStatus;
    this.customerName = customerName;
    this.saleDetailDto = saleDetailDto;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return invoiceNumber;
    case 2: return saleDate;
    case 3: return totalAmount;
    case 4: return paymentStatus;
    case 5: return customerName;
    case 6: return saleDetailDto;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.Long)value$; break;
    case 1: invoiceNumber = (java.lang.CharSequence)value$; break;
    case 2: saleDate = (java.lang.CharSequence)value$; break;
    case 3: totalAmount = (java.lang.Double)value$; break;
    case 4: paymentStatus = (java.lang.CharSequence)value$; break;
    case 5: customerName = (java.lang.CharSequence)value$; break;
    case 6: saleDetailDto = (java.util.List<com.activity.dto.SaleDetailDto>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.Long getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.Long value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'invoiceNumber' field.
   * @return The value of the 'invoiceNumber' field.
   */
  public java.lang.CharSequence getInvoiceNumber() {
    return invoiceNumber;
  }

  /**
   * Sets the value of the 'invoiceNumber' field.
   * @param value the value to set.
   */
  public void setInvoiceNumber(java.lang.CharSequence value) {
    this.invoiceNumber = value;
  }

  /**
   * Gets the value of the 'saleDate' field.
   * @return The value of the 'saleDate' field.
   */
  public java.lang.CharSequence getSaleDate() {
    return saleDate;
  }

  /**
   * Sets the value of the 'saleDate' field.
   * @param value the value to set.
   */
  public void setSaleDate(java.lang.CharSequence value) {
    this.saleDate = value;
  }

  /**
   * Gets the value of the 'totalAmount' field.
   * @return The value of the 'totalAmount' field.
   */
  public java.lang.Double getTotalAmount() {
    return totalAmount;
  }

  /**
   * Sets the value of the 'totalAmount' field.
   * @param value the value to set.
   */
  public void setTotalAmount(java.lang.Double value) {
    this.totalAmount = value;
  }

  /**
   * Gets the value of the 'paymentStatus' field.
   * @return The value of the 'paymentStatus' field.
   */
  public java.lang.CharSequence getPaymentStatus() {
    return paymentStatus;
  }

  /**
   * Sets the value of the 'paymentStatus' field.
   * @param value the value to set.
   */
  public void setPaymentStatus(java.lang.CharSequence value) {
    this.paymentStatus = value;
  }

  /**
   * Gets the value of the 'customerName' field.
   * @return The value of the 'customerName' field.
   */
  public java.lang.CharSequence getCustomerName() {
    return customerName;
  }

  /**
   * Sets the value of the 'customerName' field.
   * @param value the value to set.
   */
  public void setCustomerName(java.lang.CharSequence value) {
    this.customerName = value;
  }

  /**
   * Gets the value of the 'saleDetailDto' field.
   * @return The value of the 'saleDetailDto' field.
   */
  public java.util.List<com.activity.dto.SaleDetailDto> getSaleDetailDto() {
    return saleDetailDto;
  }

  /**
   * Sets the value of the 'saleDetailDto' field.
   * @param value the value to set.
   */
  public void setSaleDetailDto(java.util.List<com.activity.dto.SaleDetailDto> value) {
    this.saleDetailDto = value;
  }

  /**
   * Creates a new SaleDto RecordBuilder.
   * @return A new SaleDto RecordBuilder
   */
  public static com.activity.dto.SaleDto.Builder newBuilder() {
    return new com.activity.dto.SaleDto.Builder();
  }

  /**
   * Creates a new SaleDto RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new SaleDto RecordBuilder
   */
  public static com.activity.dto.SaleDto.Builder newBuilder(com.activity.dto.SaleDto.Builder other) {
    return new com.activity.dto.SaleDto.Builder(other);
  }

  /**
   * Creates a new SaleDto RecordBuilder by copying an existing SaleDto instance.
   * @param other The existing instance to copy.
   * @return A new SaleDto RecordBuilder
   */
  public static com.activity.dto.SaleDto.Builder newBuilder(com.activity.dto.SaleDto other) {
    return new com.activity.dto.SaleDto.Builder(other);
  }

  /**
   * RecordBuilder for SaleDto instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<SaleDto>
    implements org.apache.avro.data.RecordBuilder<SaleDto> {

    private java.lang.Long id;
    private java.lang.CharSequence invoiceNumber;
    private java.lang.CharSequence saleDate;
    private double totalAmount;
    private java.lang.CharSequence paymentStatus;
    private java.lang.CharSequence customerName;
    private java.util.List<com.activity.dto.SaleDetailDto> saleDetailDto;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.activity.dto.SaleDto.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.invoiceNumber)) {
        this.invoiceNumber = data().deepCopy(fields()[1].schema(), other.invoiceNumber);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.saleDate)) {
        this.saleDate = data().deepCopy(fields()[2].schema(), other.saleDate);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.totalAmount)) {
        this.totalAmount = data().deepCopy(fields()[3].schema(), other.totalAmount);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.paymentStatus)) {
        this.paymentStatus = data().deepCopy(fields()[4].schema(), other.paymentStatus);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.customerName)) {
        this.customerName = data().deepCopy(fields()[5].schema(), other.customerName);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.saleDetailDto)) {
        this.saleDetailDto = data().deepCopy(fields()[6].schema(), other.saleDetailDto);
        fieldSetFlags()[6] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing SaleDto instance
     * @param other The existing instance to copy.
     */
    private Builder(com.activity.dto.SaleDto other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.invoiceNumber)) {
        this.invoiceNumber = data().deepCopy(fields()[1].schema(), other.invoiceNumber);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.saleDate)) {
        this.saleDate = data().deepCopy(fields()[2].schema(), other.saleDate);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.totalAmount)) {
        this.totalAmount = data().deepCopy(fields()[3].schema(), other.totalAmount);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.paymentStatus)) {
        this.paymentStatus = data().deepCopy(fields()[4].schema(), other.paymentStatus);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.customerName)) {
        this.customerName = data().deepCopy(fields()[5].schema(), other.customerName);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.saleDetailDto)) {
        this.saleDetailDto = data().deepCopy(fields()[6].schema(), other.saleDetailDto);
        fieldSetFlags()[6] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.Long getId() {
      return id;
    }

    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.activity.dto.SaleDto.Builder setId(java.lang.Long value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.activity.dto.SaleDto.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'invoiceNumber' field.
      * @return The value.
      */
    public java.lang.CharSequence getInvoiceNumber() {
      return invoiceNumber;
    }

    /**
      * Sets the value of the 'invoiceNumber' field.
      * @param value The value of 'invoiceNumber'.
      * @return This builder.
      */
    public com.activity.dto.SaleDto.Builder setInvoiceNumber(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.invoiceNumber = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'invoiceNumber' field has been set.
      * @return True if the 'invoiceNumber' field has been set, false otherwise.
      */
    public boolean hasInvoiceNumber() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'invoiceNumber' field.
      * @return This builder.
      */
    public com.activity.dto.SaleDto.Builder clearInvoiceNumber() {
      invoiceNumber = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'saleDate' field.
      * @return The value.
      */
    public java.lang.CharSequence getSaleDate() {
      return saleDate;
    }

    /**
      * Sets the value of the 'saleDate' field.
      * @param value The value of 'saleDate'.
      * @return This builder.
      */
    public com.activity.dto.SaleDto.Builder setSaleDate(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.saleDate = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'saleDate' field has been set.
      * @return True if the 'saleDate' field has been set, false otherwise.
      */
    public boolean hasSaleDate() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'saleDate' field.
      * @return This builder.
      */
    public com.activity.dto.SaleDto.Builder clearSaleDate() {
      saleDate = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'totalAmount' field.
      * @return The value.
      */
    public java.lang.Double getTotalAmount() {
      return totalAmount;
    }

    /**
      * Sets the value of the 'totalAmount' field.
      * @param value The value of 'totalAmount'.
      * @return This builder.
      */
    public com.activity.dto.SaleDto.Builder setTotalAmount(double value) {
      validate(fields()[3], value);
      this.totalAmount = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'totalAmount' field has been set.
      * @return True if the 'totalAmount' field has been set, false otherwise.
      */
    public boolean hasTotalAmount() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'totalAmount' field.
      * @return This builder.
      */
    public com.activity.dto.SaleDto.Builder clearTotalAmount() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'paymentStatus' field.
      * @return The value.
      */
    public java.lang.CharSequence getPaymentStatus() {
      return paymentStatus;
    }

    /**
      * Sets the value of the 'paymentStatus' field.
      * @param value The value of 'paymentStatus'.
      * @return This builder.
      */
    public com.activity.dto.SaleDto.Builder setPaymentStatus(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.paymentStatus = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'paymentStatus' field has been set.
      * @return True if the 'paymentStatus' field has been set, false otherwise.
      */
    public boolean hasPaymentStatus() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'paymentStatus' field.
      * @return This builder.
      */
    public com.activity.dto.SaleDto.Builder clearPaymentStatus() {
      paymentStatus = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'customerName' field.
      * @return The value.
      */
    public java.lang.CharSequence getCustomerName() {
      return customerName;
    }

    /**
      * Sets the value of the 'customerName' field.
      * @param value The value of 'customerName'.
      * @return This builder.
      */
    public com.activity.dto.SaleDto.Builder setCustomerName(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.customerName = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'customerName' field has been set.
      * @return True if the 'customerName' field has been set, false otherwise.
      */
    public boolean hasCustomerName() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'customerName' field.
      * @return This builder.
      */
    public com.activity.dto.SaleDto.Builder clearCustomerName() {
      customerName = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'saleDetailDto' field.
      * @return The value.
      */
    public java.util.List<com.activity.dto.SaleDetailDto> getSaleDetailDto() {
      return saleDetailDto;
    }

    /**
      * Sets the value of the 'saleDetailDto' field.
      * @param value The value of 'saleDetailDto'.
      * @return This builder.
      */
    public com.activity.dto.SaleDto.Builder setSaleDetailDto(java.util.List<com.activity.dto.SaleDetailDto> value) {
      validate(fields()[6], value);
      this.saleDetailDto = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'saleDetailDto' field has been set.
      * @return True if the 'saleDetailDto' field has been set, false otherwise.
      */
    public boolean hasSaleDetailDto() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'saleDetailDto' field.
      * @return This builder.
      */
    public com.activity.dto.SaleDto.Builder clearSaleDetailDto() {
      saleDetailDto = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public SaleDto build() {
      try {
        SaleDto record = new SaleDto();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.Long) defaultValue(fields()[0]);
        record.invoiceNumber = fieldSetFlags()[1] ? this.invoiceNumber : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.saleDate = fieldSetFlags()[2] ? this.saleDate : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.totalAmount = fieldSetFlags()[3] ? this.totalAmount : (java.lang.Double) defaultValue(fields()[3]);
        record.paymentStatus = fieldSetFlags()[4] ? this.paymentStatus : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.customerName = fieldSetFlags()[5] ? this.customerName : (java.lang.CharSequence) defaultValue(fields()[5]);
        record.saleDetailDto = fieldSetFlags()[6] ? this.saleDetailDto : (java.util.List<com.activity.dto.SaleDetailDto>) defaultValue(fields()[6]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<SaleDto>
    WRITER$ = (org.apache.avro.io.DatumWriter<SaleDto>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<SaleDto>
    READER$ = (org.apache.avro.io.DatumReader<SaleDto>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
