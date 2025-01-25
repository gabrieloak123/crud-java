/**
 * 
 */
/**
 * 
 */
module projeto_final_bp {
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires org.junit.jupiter.api;
	
	exports br.ufrn.imd.biblioteca to javafx.graphics;	
	exports br.ufrn.imd.biblioteca.controller;
    opens br.ufrn.imd.biblioteca.controller to javafx.fxml;
}
