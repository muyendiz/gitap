`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 24.12.2016 20:39:15
// Design Name: 
// Module Name: DotMatrix
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

`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 21.12.2016 22:24:22
// Design Name: 
// Module Name: matrix
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


module DotMatrix(input logic clk,
output logic Ds,shcp,stcp,OE,MR,
output logic [7:0] Bout
 );
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 logic [23:0]renkler;
 logic [7:0]kirmizi;
 logic [7:0]yesil;
 logic [7:0]mavi;
 assign mavi = 8'b00000000;
 assign yesil = 8'b00000000;
 assign renkler [23:16]= kirmizi;
 assign renkler[15:8]= yesil;
 assign renkler[7:0] = mavi;
 logic [10:0]count;
 logic [5:0] countShcp;
 initial countShcp = 6'b000000;
 initial count = 10'b0000000000;

 initial shcp = 1'b0;
 initial stcp = 1'b0;
 initial MR = 1'b0;
 initial OE = 1'b1;
 assign Bout= 8'b01000000;
 initial Ds =renkler[0];
 logic changedClockk;
 changedClock useClock(clk,changedClockk);
 always_ff@(posedge changedClockk)begin
 if(count<4)begin count<=count+1;MR=1'b0;end
 else if(count<51)begin MR<=1'b1; shcp<=~shcp; count<=count+1;end
 
end 
 always_ff@(posedge shcp)begin 
 if(countShcp<23)begin countShcp<=countShcp+1; Ds<=renkler[countShcp]; end
 else stcp<=1'b1; OE<=1'b0; 
 end
 
 
endmodule
