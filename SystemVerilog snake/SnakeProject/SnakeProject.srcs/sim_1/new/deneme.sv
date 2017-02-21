`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 23.12.2016 18:38:22
// Design Name: 
// Module Name: deneme
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


module deneme(

    );
    
    logic clk;
     logic Pause,RButton,LButton,ResetButton,StartButton;
     logic [7:0] banodes;
    logic [7:0] katodes;
    DisplayModule dut(Pause,RButton,LButton,ResetButton,StartButton,banodes, katodes);
    
    
    
endmodule
