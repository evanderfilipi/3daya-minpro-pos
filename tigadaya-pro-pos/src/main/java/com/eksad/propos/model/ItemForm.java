package com.eksad.propos.model;

import java.util.List;

import com.eksad.propos.model.VariantModel;
import com.eksad.propos.model.ItemModel;
import com.eksad.propos.model.InvenModel;

public class ItemForm {
private ItemModel io;
private List<VariantModel> vm;
private List<InvenModel> im;
public ItemModel getIo() {
	return io;
}
public void setIo(ItemModel io) {
	this.io = io;
}
public List<VariantModel> getVm() {
	return vm;
}
public void setVm(List<VariantModel> vm) {
	this.vm = vm;
	
	
}
public List<InvenModel> getIm() {
	return im;
}
public void setIm(List<InvenModel> im) {
	this.im = im;
}

}
	