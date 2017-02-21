`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 22.12.2016 22:07:07
// Design Name: 
// Module Name: CreateRandom
// Project Name: 
// Target Devices: 
// Tool Versions: 
// Description: 
// 
// Dependencies: 
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
//////////////////////////////////////////////////////////////////////////////////


module CreateRandom(
input logic clk,
output logic [5:0]randomNum
    );
    logic [5:0]tempRandom ;
    initial tempRandom = 6'b100000;
  
    
    always_ff@(posedge clk)
    begin 
    
    tempRandom <= tempRandom +3;
   
    end
    
   assign randomNum = tempRandom;    
endmodule
