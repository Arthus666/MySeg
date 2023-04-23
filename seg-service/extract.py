'''
Description: 
Autor: Wpiper
Date: 2023-03-26 15:25:13
LastEditors: Wpiper
LastEditTime: 2023-04-10 10:20:52
'''
import cc3d
import nibabel as nib
from pathlib2 import Path
from tqdm import tqdm
import numpy as np
import os
import sys


def main(data, output, filename):
    data = Path(data).resolve()
    output = Path(output).resolve()
    assert data != output, f'postprocess data will replace original data, use another output path'
    if not output.exists():
        output.mkdir(parents=True)
    # predictions = sorted(data.glob('*.nii.gz'))
    predictions = sorted(data.glob(filename))
    for pred in tqdm(predictions):
        if not pred.name.startswith('.'):
            vol_nii = nib.load(str(pred))
            affine = vol_nii.affine
            vol = vol_nii.get_fdata()
            vol = post_processing(vol)
            vol_nii = nib.Nifti1Image(vol, affine)
            vol_nii_filename = output / pred.name
            vol_nii.to_filename(str(vol_nii_filename))


def post_processing(vol):
    vol_ = vol.copy()
    vol_[vol_ > 0] = 1
    vol_ = vol_.astype(np.int64)
    vol_cc = cc3d.connected_components(vol_)
    print(vol_cc.max())
    cc_sum = [(i, vol_cc[vol_cc == i].shape[0]) for i in range(vol_cc.max() + 1)]
    cc_sum.sort(key=lambda x: x[1], reverse=True)
    print(cc_sum)
    print(cc_sum[0][1])
    cc_sum.pop(0)  # remove background
    reduce_cc = [cc_sum[i][0] for i in range(1, len(cc_sum)) if cc_sum[i][1] < cc_sum[1][1] * 0.1]
    for i in reduce_cc:
        vol[vol_cc == i] = 0
    return vol


input_path = sys.argv[1]
output_path = sys.argv[2]
file_name = sys.argv[3]

# input_path = 'D:\\MedicalService\\UserFiles\\User_3\\segmented\\'
# output_path = 'D:\\MedicalService\\UserFiles\\User_3\\extracted\\'
# file_name = '0f593c1e-4bb8-470f-a87b-fee3dbd3b3ed.nii.gz'

print(input_path)
print(output_path)
print(file_name)

if not os.path.exists(output_path):
    os.makedirs(output_path)
main(input_path, output_path, file_name)
