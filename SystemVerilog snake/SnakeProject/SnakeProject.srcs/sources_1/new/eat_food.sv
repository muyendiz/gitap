module eat_food(input integer xHead, yHead,Foodx,Foody,
output logic eaten 
 );
always_comb begin
if(xHead==Foodx && yHead== Foody)begin eaten<=1'b1;  end   
else begin eaten<= 1'b0; end
end
endmodule
