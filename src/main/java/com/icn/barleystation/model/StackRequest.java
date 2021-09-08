package com.icn.barleystation.model;

import java.io.Serializable;

import com.sun.istack.Nullable;

public class StackRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	@Nullable
	private Integer inputs;
	@Nullable
	private Integer outputs;

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

}
