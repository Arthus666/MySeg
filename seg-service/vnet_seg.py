import os
import sys

unsegmented_path = sys.argv[1]
segmented_path = sys.argv[2]


command = "cd E:/VnetSeg/PaddleSeg/contrib/MedicalSeg/ & " \
          "python deploy/python/competition_infer.py " \
          "--config output_vnet/export_model/deploy.yaml " \
          "--benchmark False " \
          "--image_path " + unsegmented_path + " --save_dir " + segmented_path

# 打印推理命令
print(command)

# 执行推理命令
os.system(command)

# 删除生成的.npy文件
npy_path = unsegmented_path.replace("nii.gz", "npy")
print(npy_path)
os.remove(npy_path)
