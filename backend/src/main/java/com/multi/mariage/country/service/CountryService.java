package com.multi.mariage.country.service;

import com.multi.mariage.country.domain.Country;
import com.multi.mariage.country.dto.response.CountryResponse;
import com.multi.mariage.country.vo.CountriesVO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CountryService {
    public CountryResponse findCountries() {
        List<CountriesVO> countryValues = getCountryValues();
        return CountryResponse.from(countryValues);
    }

    private List<CountriesVO> getCountryValues() {
        return Arrays.stream(Country.values())
                .map(CountriesVO::from)
                .toList();
    }
}
