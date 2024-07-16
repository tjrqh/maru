package project.maru.presentation;


import org.springframework.web.bind.annotation.GetMapping;

public class DefaultController {

  @GetMapping("/")
  public String indexController() {
    return "ok";
  }

}
