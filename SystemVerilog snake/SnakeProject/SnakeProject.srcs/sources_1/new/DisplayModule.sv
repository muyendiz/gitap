module DisplayModule(
input logic clk,
input logic StartButton, RButton, LButton, Pause,ResetButton,
output logic Ds,shcp,stcp,OE,MR,
output logic [7:0] Bout
    );
    logic [23:0] renkler ;
    logic [7:0] kirmizi;
     logic [7:0] yesil;
      logic [7:0] mavi;
  
  assign mavi =8'b00000000 ;
  assign yesil = 8'b00000000;
 assign renkler[23:16] = kirmizi;
 assign renkler[15:8]= yesil;
 assign renkler[7:0]= mavi; 
 
   integer wormx[63:0];
   integer wormy[63:0];
   integer Food [1:0];
   
  logic[7:0]Line1=0;
  logic[7:0]Line2=0;
  logic[7:0]Line3=0;
  logic[7:0]Line4=0; 
  logic[7:0]Line5=0;
  logic[7:0]Line6=0;
  logic[7:0]Line7=0;
  logic[7:0]Line8=0;
  
            
            
   
   Positionworm takePosition(clk,StartButton, RButton, LButton, Pause,ResetButton,wormx,wormy,Food);
   
   
   
      
    logic f;
    logic e;
    
    
    logic [7:0]counter;
  logic [8:0]i=1;  
   logic [2:0]a=0; 
    logic [6:0]d=0;
    logic changed;
    logic changed2;
 ClockModulee change(clk,changed,changed2);
    always_ff@(posedge changed)begin counter<=counter+1; end
    
    
    assign f=counter[7];
    assign e=~ f;
    
    always_ff@(posedge changed)begin i<=i+1; end 
  always_comb begin
    if (i<4)
    MR<=1'b0;
    else
    MR<=1'b1;
    
    if(i>3&&i<28)
     Ds<= renkler[i-4];
    else 
    Ds<=1'b0;
   
    
    if (i<28) 
    begin
    shcp<=f;        
    stcp<=e; end
    else begin
    shcp<=1'b0;
    stcp<=1'b1;
    end end
    
    always_ff@(posedge f)
    begin
    if (i>28 && i<409) 
    OE<=1'b0;
    else
    OE<=1'b1;
    end
    
    
    always_ff@(posedge f) //then--bir satýr tamamlandýðýnda a bir arttýrýlýyor 2. satýra geçmek için.
    begin
    if (i==410) 
    a<=a+1;
    end 
    
    
    always_ff@(posedge f) //then--satrlar ve sutunlar tamamlandýðýnda yeni görüntü için(ful ekran) d bir arttýrýlýyor.
    begin
    if (i==410) begin
    if (a==7) 
    d<=d+1;
    end
    end
    
      
   
         always_comb begin      
      if (a==0) 
      Bout<=8'b10000000;
      else if (a==1) 
      Bout<=8'b01000000;
      else if (a==2)
      Bout<=8'b00100000;
      else if (a==3) 
      Bout<=8'b00010000;
      else if (a==4) 
      Bout<=8'b00001000;
      else if (a==5) 
      Bout<=8'b00000100;
      else if (a==6) 
      Bout<=8'b00000010;
      else
      Bout<=8'b00000001;
      end
     
   
      always_comb // taking position from wormx and wormy array 
      begin
      for (int i = 0 ; i<=63;i++)begin
      integer x ;
      x<= wormx[i];
      if(wormy[i]==1)begin Line1[x-1]<=1'b1;   end   
       if(wormy[i]==2)begin Line2[x-1]<=1'b1;   end   
        if(wormy[i]==3)begin Line3[x-1]<=1'b1;   end   
         if(wormy[i]==4)begin Line4[x-1]<=1'b1;   end   
          if(wormy[i]==5)begin Line5[x-1]<=1'b1;   end   
           if(wormy[i]==6)begin Line6[x-1]<=1'b1;   end    
           if(wormy[i]==7)begin Line7[x-1]<=1'b1;   end
            if(wormy[i]==8)begin Line8[x-1]<=1'b1;   end      
           end end
         
           always_comb begin
           integer m =Food[1] ;
            
          if(Food[0]==1)begin Line1[m-1]<=1'b1;   end   
         if(Food[0]==2)begin Line2[m-1]<=1'b1;   end
         if(Food[0]==3)begin Line3[m-1]<=1'b1;   end   
         if(Food[0]==4)begin Line4[m-1]<=1'b1;   end
         if(Food[0]==5)begin Line5[m-1]<=1'b1;   end   
         if(Food[0]==6)begin Line6[m-1]<=1'b1;   end
         if(Food[0]==7)begin Line7[m-1]<=1'b1;   end   
        if(Food[0]==8)begin Line8[m-1]<=1'b1;   end
         end 
         
         always_comb
         begin
         case (a)
        0:kirmizi<=Line1;
         1:kirmizi<=Line2;
          2:kirmizi<=Line3;
           3:kirmizi<=Line4;
            4:kirmizi<=Line5;
             5:kirmizi<=Line6; 
             6:kirmizi<=Line7;
              7:kirmizi<=Line8; endcase
              end
             
           
     endmodule
