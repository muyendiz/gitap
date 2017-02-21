`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 22.12.2016 20:50:53
// Design Name: 
// Module Name: ClockModule
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


module ClockModule(
input logic clk, 
output logic  [10:0] first,

output logic [2:0] second,
output logic [3:0] third
    );
    logic [11:0] changePeriod;
    logic [11:0] count_change;
    logic [10:0] mfirst;
    logic [3:0] mthird;
    logic [2:0] msecond;
       
       initial changePeriod= 12'b110000110101;
       initial count_change=0;
       initial mfirst=0;
       initial mthird=0;
       initial msecond=0;
       logic changedOne;
    
       always_ff@(posedge clk)begin
       
        count_change <= count_change + 1;
                  if(count_change == changePeriod) begin
                      
                      mthird <= mthird + 1;
                           if (mthird == 4'b1000)begin
                                  mfirst <= mfirst + 1;                             
                               if (mfirst == 9'b111110100) begin
                                      msecond <= msecond + 1;
                                      mfirst<=0;
                               end ;
                           mthird <=0;
                           end 
                     count_change <= 0;
                  end 
              end 
       
       
       
      assign first = mfirst;
      assign second = msecond;
      assign third = mthird;
      
       
endmodule
