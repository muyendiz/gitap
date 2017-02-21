# 
# Synthesis run script generated by Vivado
# 

set_msg_config -id {HDL 9-1061} -limit 100000
set_msg_config -id {HDL 9-1654} -limit 100000
create_project -in_memory -part xc7a35tcpg236-1

set_param project.singleFileAddWarning.threshold 0
set_param project.compositeFile.enableAutoGeneration 0
set_param synth.vivado.isSynthRun true
set_property webtalk.parent_dir C:/Users/furkanerdem/Desktop/SnakeProject/SnakeProject.cache/wt [current_project]
set_property parent.project_path C:/Users/furkanerdem/Desktop/SnakeProject/SnakeProject.xpr [current_project]
set_property default_lib xil_defaultlib [current_project]
set_property target_language Verilog [current_project]
set_property ip_output_repo c:/Users/furkanerdem/Desktop/SnakeProject/SnakeProject.cache/ip [current_project]
set_property ip_cache_permissions {read write} [current_project]
read_verilog -library xil_defaultlib -sv {
  C:/Users/furkanerdem/Desktop/SnakeProject/SnakeProject.srcs/sources_1/new/CreateRandom.sv
  C:/Users/furkanerdem/Desktop/SnakeProject/SnakeProject.srcs/sources_1/new/ClockModulee.sv
  C:/Users/furkanerdem/Desktop/SnakeProject/SnakeProject.srcs/sources_1/new/PositionSnake.sv
  C:/Users/furkanerdem/Desktop/SnakeProject/SnakeProject.srcs/sources_1/new/DisplayModule.sv
}
foreach dcp [get_files -quiet -all *.dcp] {
  set_property used_in_implementation false $dcp
}
read_xdc C:/Users/furkanerdem/Desktop/SnakeProject/SnakeProject.srcs/constrs_1/new/constraint.xdc
set_property used_in_implementation false [get_files C:/Users/furkanerdem/Desktop/SnakeProject/SnakeProject.srcs/constrs_1/new/constraint.xdc]


synth_design -top DisplayModule -part xc7a35tcpg236-1


write_checkpoint -force -noxdef DisplayModule.dcp

catch { report_utilization -file DisplayModule_utilization_synth.rpt -pb DisplayModule_utilization_synth.pb }
