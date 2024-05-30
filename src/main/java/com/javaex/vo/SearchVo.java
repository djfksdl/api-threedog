package com.javaex.vo;

import java.util.List;

public class SearchVo {

	private String keyword;
	private List<String> selectedCities;
	private List<List<Integer>> selectedWeights;
	private List<String> selectedTypes;
	private List<Integer> selectedPrices;

	public SearchVo() {
		super();
	}

	public SearchVo(String keyword, List<String> selectedCities, List<List<Integer>> selectedWeights,
			List<String> selectedTypes, List<Integer> selectedPrices) {
		super();
		this.keyword = keyword;
		this.selectedCities = selectedCities;
		this.selectedWeights = selectedWeights;
		this.selectedTypes = selectedTypes;
		this.selectedPrices = selectedPrices;
	}
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public List<String> getSelectedCities() {
		return selectedCities;
	}

	public void setSelectedCities(List<String> selectedCities) {
		this.selectedCities = selectedCities;
	}

	public List<List<Integer>> getSelectedWeights() {
		return selectedWeights;
	}

	public void setSelectedWeights(List<List<Integer>> selectedWeights) {
		this.selectedWeights = selectedWeights;
	}

	public List<String> getSelectedTypes() {
		return selectedTypes;
	}

	public void setSelectedTypes(List<String> selectedTypes) {
		this.selectedTypes = selectedTypes;
	}

	public List<Integer> getSelectedPrices() {
		return selectedPrices;
	}

	public void setSelectedPrices(List<Integer> selectedPrices) {
		this.selectedPrices = selectedPrices;
	}

	@Override
	public String toString() {
		return "SearchVo [keyword=" + keyword + ", selectedCities=" + selectedCities + ", selectedWeights="
				+ selectedWeights + ", selectedTypes=" + selectedTypes + ", selectedPrices=" + selectedPrices + "]";
	}

}