
module ClockModulee(input logic clock,
output logic changedClock1,
output logic changedClock2
    );
    logic [30:0] count=0;
    logic [30:0] count1= 0 ;
     always@ (posedge clock) begin
           count <= count + 1;
           if (count==20000)
           count <= 28'd0;
           count1<=count1 +1 ;
           if (count==0)
           changedClock1 <= 1'b1;
           if(count1==9*410) begin count1<=1'b0 ; end
           if(count!=0)
           changedClock1 <= 1'b0;
           if(count1==0)changedClock2<=1'b1;
           if(count1!=0)changedClock1<=1'b0;
           end
endmodule