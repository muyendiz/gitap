module game_over(
input integer wormx[63:0],
input integer wormy[63:0],
output logic gameOver
);

 always_comb begin
                              for (int m = 3;m<=63; m++) begin
                                  if (wormy[0] == wormy[m] && wormx[0] == wormx[m])begin
                                  gameOver <= 1'b1;
                                  end
                                  else begin gameOver <= 1'b0;end
                                 
                                  end 
                              end      
endmodule