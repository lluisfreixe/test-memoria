package cat.dgp.openshift;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {
	
	// VERSIO 1
	
	String appName = "test-memoria";

	@GetMapping("/entrada")
	public String entrada(Model model) {
		String capacitat = memoria();
		String data = obtenirData();
		String hora = obtenirHora();
		model.addAttribute("appName", appName);
		model.addAttribute("capacitat", capacitat);
		model.addAttribute("data", data);
		model.addAttribute("hora", hora);
	    return "inici";
	  }
	
	private String obtenirData () {
		Date date = new Date();
		DateFormat formatData = DateFormat.getDateInstance(DateFormat.SHORT);
		String data = formatData.format(date);
		return data;
	}

	private String obtenirHora () {
		Date date = new Date();
		DateFormat formatHora = new SimpleDateFormat("HH:mm:ss");
		String hora = formatHora.format(date);
		return hora;
	}

	private String memoria () {
		String bloc = "11111111222222223333333344444444";
		int capacitat = bloc.length() * 32768;
		DecimalFormat formatoImporte = new DecimalFormat("###,###,###.##");
		//NumberFormat formatoImporte = NumberFormat.getNumberInstance();
		//NumberFormat formatoImporte = NumberFormat.getCurrencyInstance();
		//formatoImporte = NumberFormat.getCurrencyInstance(new Locale("es","ES"));
		String cap = formatoImporte.format(capacitat);
		String cadena = "";
		for (int i=0; i <= 32768; i++) {
			cadena = cadena + bloc;
		}
		System.out.println("metode memoria executat.");
		return cap;
	}

}
