import { Component } from '@angular/core';

@Component({
  selector: 'app-calculadora',
  imports: [],
  templateUrl: './calculadora.html',
  styleUrl: './calculadora.css',
})
export class Calculadora {

  num1: number = 0;
  num2: number = 0;
  resultado: number = 0;

  somar(a: number, b: number) {
    this.resultado = a + b;
  }

  subtrair(a: number, b: number) {
    this.resultado = a - b;
  }

  multiplicar(a: number, b: number) {
    this.resultado = a * b;
  }

  dividir(a: number, b: number) {
    this.resultado = a / b;
  }
}
