package com.cule.calculator.controller;

import com.cule.calculator.models.CalculatorOperations;
import com.cule.calculator.models.OperationModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CalculatorController {

    CalculatorOperations calculatorOperations = new CalculatorOperations();
    OperationModel operationModel = new OperationModel();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("operationModel", operationModel);
        return "index";
    }

    @RequestMapping(params = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute("operationModel") OperationModel operationModel, Model model) {
        model.addAttribute("result", calculatorOperations.add(operationModel.getA(), operationModel.getB()));
        return "index";
    }

    @RequestMapping(params = "sub", method = RequestMethod.POST)
    public String substract(@ModelAttribute("operationModel") OperationModel operationModel, Model model) {
        model.addAttribute("result", calculatorOperations.subtract(operationModel.getA(), operationModel.getB()));
        return "index";
    }

    @RequestMapping(params = "mul", method = RequestMethod.POST)
    public String multiplication(@ModelAttribute("operationModel") OperationModel operationModel, Model model) {
        model.addAttribute("result", calculatorOperations.multiplication(operationModel.getA(), operationModel.getB()));
        return "index";
    }

    @RequestMapping(params = "div", method = RequestMethod.POST)
    public String division(@ModelAttribute("operationModel") OperationModel operationModel, Model model) {
        model.addAttribute("result", calculatorOperations.division(operationModel.getA(), operationModel.getB()));
        return "index";
    }
}
