`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 22.12.2016 23:04:23
// Design Name: 
// Module Name: Positionworm
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


module Positionworm(
input logic clk,
input logic StartButton, RButton, LButton, Pause,ResetButton,
output integer  wormx[63:0],
output integer wormy[63:0],
output integer Foodxy[1:0]

    );
   
    logic [5:0] Food;
    initial  wormx ={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,4} ;
      
      initial wormy={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2};
      logic [1:0] direction = 2'b11;
      logic[1:0] dirRight=2'b01;
      logic [1:0]dirLeft=2'b01;
    
    
     
      logic start=0;
      logic changedClock;
      logic changedClock2;
    
     ClockModulee change(clk,changedClock2,changedClock); 
        
      integer Foodx;
      integer Foody;
      initial Foodx = 4;
      initial Foody = 4;  
      
      integer newFoodx;
      integer newFoody; 
   
    generate_food gen(clk,newFoodx,newFoody);
      
      assign Foodxy = {Foodx,Foody};
   
     integer lastwormx[63:0] ;
    
      integer  lastwormy[63:0];
          
          
          
          logic gameisOver;
         
         
          game_over(wormx[0],wormy[0],Foodx,Foody,gameisOver); 
                    
         
          logic stop ;
          initial stop = 1'b1;
         
         logic yanipSon ;
         initial yanipSon = 0;
        
        logic isFoodEaten;
          int x;
          int y;
   
   
   always_ff@(posedge StartButton)begin start<=1'b1;stop = 1'b0; end
   
   
   always_ff@(posedge ResetButton)begin // this part resets all values when reset button is pushed
    wormx <= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,4} ;
      wormy <= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2};
      Foodx<=4;
      Foody<=4;
      stop<=1'b0 ;                     
    start<=1'b0; direction<=2'b11; end
  
   always_ff@(posedge Pause)begin stop<=1'b1; end
  
   always_ff@(posedge LButton) begin direction<=dirLeft;end
  
   always_ff@(posedge RButton) begin direction<=dirRight;end
 
                      always_ff@( posedge changedClock) begin
                          if(!stop)begin
                          
                          if (gameisOver ) begin
                              if (yanipSon == 0) begin
                                  wormy<= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
                                  wormx <= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
                              end
                              else begin 
                                  wormy <= lastwormy ;
                                  wormx <= lastwormx ;
                              end 
                              yanipSon <= ~yanipSon;
                            end  
                         
                         
                          else if (start) begin
                                      x <= wormx[0];
                                      y <= wormy[0];
                                      // this parts updating head of worm according to direction of its movement
                                      if (direction == 2'b11) begin
                                          if (y > 1) begin
                                              y <= y - 1;end
                                          else begin
                                              y <= 8;
                                          end end
                              
                                      else if(direction == 2'b01) begin
                                          if (y < 8) begin
                                           y <= y + 1;
                                          end
                                          else begin
                                              y <= 1; end
                                          end 
                                  
                                      else if (direction == 2'b10) begin
                                          if (x > 1) begin
                                              x <= x - 1;end
                                          else begin
                                              x <= 8; end
                                          end 
                              
                                      else if (direction == 2'b00) begin
                                          if (x < 8) begin
                                              x <= x + 1; end
                                          else begin
                                              x<= 1;end end
                                          
                                      end 
                                  
                                  // this part is for motion of the worm when it eats food, its length is increased
                                  eat_food eat(x,y,Foodx,Foody,isFoodEaten);
                                  if (isFoodEaten) begin
                                      
                                      for (int n= 63;n>=1; n++)begin
                                          wormy[n] <= wormy[n-1];
                                          wormx[n] <= wormx[n-1];
                                      end 
                                      
                                      Foodx <= newFoodx;
                                      Foody <= newFoody;
                                      
                                    end
                                 
                                 // this part is for motion of worm, length of worm is not changed     
                                    else begin
                                       for (int n= 63;n>=1; n++)begin
                                          if (wormy [n] > 0) begin
                                              wormy[n] <= wormy[n-1];
                                              wormx[n] <= wormx[n-1]; end
                                          else begin
                                              wormy[n] <= 0;
                                               wormx[n] <= 0; end
                                          
                                      end 
                                  end
                                  // updating head of worm
                                  wormy[0] <= y;
                                  wormx[0] <= x;
                  
                          end   end                           
                            
                             always_comb begin
                              if(gameisOver)
                                  begin
                                  lastwormx <= wormx;
                                  lastwormy <= wormy;
                                  end 
                              end     
                                              
                  
              
                    
           
                 //this part provides updating  right and left direction whenever snakes change its direction
                      always@( RButton) begin  if(RButton) begin 
                          dirRight <= direction + 1;
                      end 
                  end 
                      
              always@(LButton) begin  if(LButton) begin
                                           dirLeft <= direction - 1;
                                       end 
                                   end 
                                       
      
      
      
      
endmodule
