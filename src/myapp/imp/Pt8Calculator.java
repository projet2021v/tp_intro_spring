package myapp.imp;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import myapp.services.ICalculator;

@Service
@Qualifier("pt8calc")
public class Pt8Calculator implements ICalculator {

	@Override
	public double add(double a, double b) {
		return (a + b);
	}

}
