`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 23.12.2016 18:18:43
// Design Name: 
// Module Name: clockk
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


module clockk(input logic clock,
output logic changedClock

    );
      logic [30:0] count=0;
       always@ (posedge clock) begin
             count <= count + 1;
             if (count==2000000)
             count <= 28'd0;
             if (count==0)
             changedClock <= 1'b1;
             else
             changedClock <= 1'b0;
             end
endmodule
