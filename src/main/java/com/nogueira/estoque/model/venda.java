package com.nogueira.estoque.model;
import java.time.LocalDate;


   public class venda {
      private int id;
      private LocalDate data;


      public venda(int id, LocalDate data) {
         this.id = id;
         this.data = data;
      } 
      
      public int getId() {
            return id;
      }
      public void setId(int id) {
            this.id = id;
      }
      public LocalDate getData() {
            return data;
      }
      public void setData(LocalDate data) {
            this.data = data;
      }


      @Override
      public String toString() {
         return "ID: " + id +
               " | Data: " + data;
      }
   }


