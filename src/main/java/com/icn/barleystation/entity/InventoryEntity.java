package com.icn.barleystation.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.Nullable;

@Table(name = "INVENTORY")
@Entity
public class InventoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInventory;
	@OneToOne
	@JoinColumn(name = "idItem")
	private ItemEntity item;
	@Nullable
	private Integer stack;
	@Nullable
	private Integer inputs;
	@Nullable
	private Integer outputs;
	@Nullable
	private Integer total;
	@Nullable
	private Date updateDate;
	private String itemTag;
	private Date createdDate;

	public Integer getIdInventory() {
		return idInventory;
	}

	public void setIdInventory(Integer idInventory) {
		this.idInventory = idInventory;
	}

	public ItemEntity getItem() {
		return item;
	}

	public void setItem(ItemEntity item) {
		this.item = item;
	}

	public Integer getStack() {
		return stack;
	}

	public void setStack(Integer stack) {
		this.stack = stack;
	}

	public Integer getInputs() {
		return inputs;
	}

	public void setInputs(Integer inputs) {
		this.inputs = inputs;
	}

	public Integer getOutputs() {
		return outputs;
	}

	public void setOutputs(Integer outputs) {
		this.outputs = outputs;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getItemTag() {
		return itemTag;
	}

	public void setItemTag(String itemTag) {
		this.itemTag = itemTag;
	}

	@Override
	public String toString() {
		return "InventoryEntity [idInventory=" + idInventory + ", item=" + item + ", stack=" + stack + ", inputs="
				+ inputs + ", outputs=" + outputs + ", total=" + total + ", updateDate=" + updateDate + ", itemTag="
				+ itemTag + ", createdDate=" + createdDate + "]";
	}

}
