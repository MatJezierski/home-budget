package pl.mpas.homebudget.service;

import java.math.BigDecimal;
import java.util.Map;

public interface ChartsService {

    Map<String,BigDecimal> readCategoriesOverAmounts();
}
