`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 25.12.2016 15:35:18
// Design Name: 
// Module Name: generate_food
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


module generate_food(input logic clk,
output integer Foodx,Foody

    );
    
    logic [5:0]Foodxy;
    CreateRandom generateRandom(clk,Foodxy );
       assign Foody= Foodxy / 8 +1 ;
        assign Foodx= Foodxy % 8 +1;
    
    
endmodule
