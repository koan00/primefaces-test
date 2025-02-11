package org.primefaces.test;

import java.io.Serializable;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {

	private static final long serialVersionUID = 1L;

	private String txt1;
	private String txt2;
	
	private final List<String> countries = List.of("country 1","country 2","country 3","country 4","country 5","country 6");

    @PostConstruct
    public void init() {

    }

    public List<String> completeText(String query) {
        final String queryLowerCase = query.toLowerCase();
        return countries.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
    }
}
