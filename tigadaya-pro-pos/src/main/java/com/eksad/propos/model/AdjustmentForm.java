package com.eksad.propos.model;

import java.util.List;

public class AdjustmentForm {
	private AdjustmentModel ad;
	private List<AdjustmentInputModel> ai;
	
	public AdjustmentModel getAd() {
		return ad;
	}
	public void setAd(AdjustmentModel ad) {
		this.ad = ad;
	}
	public List<AdjustmentInputModel> getAi() {
		return ai;
	}
	public void setAi(List<AdjustmentInputModel> ai) {
		this.ai = ai;
	}
}