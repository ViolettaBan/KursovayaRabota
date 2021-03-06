package by.vita02.frontend.controllers;

import by.vita02.frontend.connection.SocketService;
import by.vita02.frontend.dto.QueryDTO;
import by.vita02.frontend.services.LastQueryService;
import by.vita02.frontend.stageConfig.StageConfig;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.regex.Pattern;

public class CompanyRegistrationController {

  @FXML private TextField NameTextField;

  @FXML private TextField SphereTextField;

  @FXML private TextField CountryTextField;

  @FXML private TextField CityTextField;

  @FXML private TextField AddressTextField;

  @FXML private Button RegistrationButton;

  @FXML private Text CompanyValidationField;

  @FXML private Text CountryValidationField;

  @FXML private Text SphereValidationField;

  @FXML private Text CityValidationField;

  @FXML private Text AddressValidationField;

  @FXML
  void initialize() {
    RegistrationButton.setOnAction(
        actionEvent -> {
          JsonObject jsonObject = validate();
          Gson gson = new Gson();
          if (jsonObject == null) return;
          JsonObject client = LastQueryService.getLastQuery();
          client.add("company", jsonObject);
          QueryDTO queryDTO = new QueryDTO((long) -1, "saveClient");
          try {
            SocketService.writeLine(gson.toJson(queryDTO));
            SocketService.writeLine(client.toString());
          } catch (IOException e) {
            e.printStackTrace();
          }
          try {
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/signIn.fxml"));
            StageConfig.stage.setScene(new Scene(root, 800, 450));
          } catch (IOException e) {
            e.printStackTrace();
          }
        });
  }

  private JsonObject validate() {
    boolean status = true;
    JsonObject jsonObject = new JsonObject();
    if (NameTextField.getText().isEmpty()) {
      status = false;
      CompanyValidationField.setText("?????????????? ????????????????");
    } else if (Pattern.matches("[??-??A-Z][??-????-??a-zA-Z\\s]*", NameTextField.getText())) {
      jsonObject.addProperty("name", NameTextField.getText());
      CompanyValidationField.setText("");
    } else {
      status = false;
      CompanyValidationField.setText("???????????????? ????????????");
    }

    if (SphereTextField.getText().isEmpty()) {
      status = false;
      SphereValidationField.setText("?????????????? ??????????");
    } else if (Pattern.matches("[??-????-??a-zA-Z]*", SphereTextField.getText())) {
      jsonObject.addProperty("sphere", SphereTextField.getText());
      SphereValidationField.setText("");
    } else {
      status = false;
      SphereValidationField.setText("???????????????? ????????????");
    }

    if (CountryTextField.getText().isEmpty()) {
      status = false;
      CountryValidationField.setText("?????????????? ????????????");
    } else if (Pattern.matches("[??-??A-Z][??-????-??a-z]*", CountryTextField.getText())) {
      jsonObject.addProperty("country", CountryTextField.getText());
      CountryValidationField.setText("");
    } else {
      status = false;
      CountryValidationField.setText("???????????????? ????????????");
    }

    if (CityTextField.getText().isEmpty()) {
      status = false;
      CityValidationField.setText("?????????????? ??????????");
    } else if (Pattern.matches("[??-??A-Z][??-????-??a-z]*", CityTextField.getText())) {
      jsonObject.addProperty("city", CityTextField.getText());
      CityValidationField.setText("");
    } else {
      status = false;
      CityValidationField.setText("???????????????? ????????????");
    }

    if (AddressTextField.getText().isEmpty()) {
      AddressValidationField.setText("?????????????? ??????????");
      status = false;
    } else {
      jsonObject.addProperty("address", AddressTextField.getText());
    }
    if (!status) return null;
    return jsonObject;
  }
}
