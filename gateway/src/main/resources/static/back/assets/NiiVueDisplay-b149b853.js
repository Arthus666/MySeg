import"./default-d6449ec9.js";import{_ as $,L as G,a as z}from"./index-e08aa956.js";/* empty css              *//* empty css              */import{_ as j}from"./index-f13b2e24.js";import{_ as H,r as U,a as T,o as Y,u as q,g as J,b as P,c as K,d as c,e as S,w as s,f as p,h as V,i as b,F as w,j as m,k as u,t as y,l as x,m as Q,p as W,n as X,q as g}from"./index-1e170dd9.js";import{_ as Z}from"./MyLogo-dc756089.js";import{N as ee}from"./niivue.es-963f498d.js";import{d as ae}from"./data-1a31d7d2.js";import"./icon-d0fda4a2.js";import{_ as oe,M as le,a as se}from"./Menu-7d70b547.js";import"./index-6780caaa.js";import"./collapseMotion-aa2d52e7.js";import"./RightOutlined-7158796b.js";import"./LeftOutlined-398fc9b5.js";const k=h=>(W("data-v-964a987e"),h=h(),X(),h),ne=k(()=>g("div",{style:{display:"flex","justify-content":"center"}},[g("img",{src:Z,alt:"",width:"80",height:"80"})],-1)),te=k(()=>g("br",null,null,-1)),ie=k(()=>g("br",null,null,-1)),re=k(()=>g("canvas",{id:"gl1"},null,-1)),pe={__name:"NiiVueDisplay",setup(h){const F=U(ae),I=T("draw.gz.nii"),n=T(!0),d=T(""),e=new ee({dragAndDropEnabled:!0,backColor:[0,0,0,1],show3Dcrosshair:!0}),N=()=>{try{e.setRadiologicalConvention(!1),e.attachTo("gl1"),e.setClipPlane([.3,270,0]),e.setRenderAzimuthElevation(120,10),e.setSliceMM(!0),e.opts.multiplanarForceRender=!1,e.graph.autoSizeMultiplanar=!0,e.graph.opacity=1,e.drawOpacity=.5,e.opts.isColorbar=!1,e.loadVolumes([{url:d.value}]),e.setSliceType(e.sliceTypeRender)}catch(o){console.log(o)}};Y(()=>{const o=q(),a=o.params.id,l=o.params.file_id,f=localStorage.getItem("user_token");a!=="0"?(console.log("云端上传",a,l),J(a,{user_token:f}).then(r=>{if(r.code==="200"){const _=r.data.File.filePath.split("\\").splice(2);I.value=_[_.length-1];const v=_.join("/");d.value="./api/"+v,P("display",r.data.File.fileId,{user_token:f}).then(C=>{console.log("更新记录",C,"display")}),console.log("文件路径：",d.value),console.log("文件名称：",I.value),N()}else console.error(r)})):(P("display",l,{user_token:f}).then(r=>{console.log("更新记录",r,"display")}),K(l,{user_token:f}).then(r=>{if(console.log("本地上传"),r.code==="200"){const v=r.data.filePath.split("\\").splice(2).join("/");d.value="./api/"+v,N(),console.log("文件路径：",d.value)}else console.error(r)}))});const D=o=>{o.name==="保存"?e.saveImage(I.value,!0):o.name==="截图"?e.saveScene("ScreenShot.png"):o.name==="撤销"?e.drawUndo():o.name==="mesh"||o.name==="FLAIR"||o.name==="mni152"||o.name==="CT"||o.name==="CT CBF"||o.name},R=(o,a)=>{a.name==="关闭"?e.setDrawingEnabled(!1):e.setDrawingEnabled(!0),a.name==="轴状"?e.setSliceType(e.sliceTypeAxial):a.name==="矢状"?e.setSliceType(e.sliceTypeCoronal):a.name==="冠状"?e.setSliceType(e.sliceTypeSagittal):a.name==="3D"?e.setSliceType(e.sliceTypeRender):a.name==="A+C+S"?(e.opts.multiplanarForceRender=!1,e.setSliceType(e.sliceTypeMultiplanar)):a.name==="A+C+S+R"?(e.opts.multiplanarForceRender=!0,e.setSliceType(e.sliceTypeMultiplanar)):a.name==="灰色系"?(e.volumes[0].colorMap="Gray",e.updateGLVolume()):a.name==="棕红色系"?(e.volumes[0].colorMap="Plasma",e.updateGLVolume()):a.name==="松绿色系"?(e.volumes[0].colorMap="Viridis",e.updateGLVolume()):a.name==="赤橙色系"?(e.volumes[0].colorMap="Inferno",e.updateGLVolume()):a.name==="彩色系"?(e.loadDrawingFromUrl(`${d.value}`),e.updateGLVolume()):a.name==="红色"?e.setPenValue(1,n.value):a.name==="绿色"?e.setPenValue(2,n.value):a.name==="蓝色"?e.setPenValue(3,n.value):a.name==="黄色"?e.setPenValue(4,n.value):a.name==="青色"?e.setPenValue(5,n.value):a.name==="紫色"?e.setPenValue(6,n.value):a.name==="擦除"?e.setPenValue(0,n.value):a.name==="擦除簇"?e.setPenValue(-0,n.value):a.name==="增长擦除簇"?e.setPenValue(NaN,n.value):a.name==="黑色增长擦除簇"?e.setPenValue(Number.NEGATIVE_INFINITY,n.value):a.name==="明亮增长擦除簇"?e.setPenValue(Number.POSITIVE_INFINITY,n.value):a.name==="对比度"?e.opts.dragMode=e.dragModes.contrast:a.name==="测量"?e.opts.dragMode=e.dragModes.measurement:a.name==="平移/缩放"?e.opts.dragMode=e.dragModes.pan:a.name==="无"&&(e.opts.dragMode=e.dragModes.none),a.isSelected=!0,o.forEach(l=>{l.name!=a.name&&(l.isSelected=!1)})},B=o=>{o.isSelected=!o.isSelected},L=o=>{o.name==="色条"?(e.opts.isColorbar=!e.opts.isColorbar,e.drawScene()):o.name==="放射性"?(e.opts.isRadiologicalConvention=!e.opts.isRadiologicalConvention,e.drawScene()):o.name==="渲染十字准线"&&(e.opts.show3Dcrosshair=!e.opts.show3Dcrosshair,e.drawScene()),o.name==="渲染剪辑平面"?(e.scene.clipPlaneDepthAziElev[0]>1?e.setClipPlane([.3,270,0]):e.setClipPlane([2,270,0]),e.drawScene()):o.name==="世界坐标"?e.setSliceMM(!e.opts.isSliceMM):o.name==="平滑插值"?e.setInterpolation(!e.opts.isNearestInterpolation):o.name==="背景色-暗黑"?(e.opts.backColor[0]<.5?e.opts.backColor=[1,1,1,1]:e.opts.backColor=[0,0,0,1],e.drawScene()):o.name==="填充轮廓"?(n.value=!n.value,e.setPenValue(e.opts.penValue,n.value)):o.name==="笔覆盖所有"?e.drawFillOverwrites=!e.drawFillOverwrites:o.name==="半透明"&&(e.drawOpacity>.75?e.drawOpacity=.5:e.drawOpacity=1,e.drawScene()),o.isSelected=!o.isSelected},A=o=>{if(o.name==="消除雾化"){let a=parseInt(prompt("Remove Haze (1..5)","5"));e.removeHaze(a)}else if(o.name==="增长剪切")e.drawGrowCut();else if(o.name==="最大类间方差法"){let a=parseInt(prompt("Segmentation classes (2..4)","3"));e.drawOtsu(a)}};return(o,a)=>{const l=oe,f=j,r=se,M=le,_=G,v=z,C=$;return c(),S(C,{style:{"font-family":"'Arial','Microsoft YaHei','黑体','宋体',sans-serif"}},{default:s(()=>[p(_,{width:"150"},{default:s(()=>[ne,p(M,{style:{width:"150px"},mode:"vertical",theme:"dark"},{default:s(()=>[(c(!0),V(w,null,b(F,(t,ue)=>(c(),S(r,{key:t.title},{title:s(()=>[u(y(t.title),1)]),default:s(()=>[(c(!0),V(w,null,b(t.items,(i,E)=>(c(),S(l,{key:i.name,onClick:x(O=>t.type=="fun"?D(i):t.type=="only"?R(t.items,i):B(i),["stop"])},{default:s(()=>[u(y(i.isSelected?"• ":"  ")+y(i.name),1)]),_:2},1032,["onClick"]))),128)),t.otheritems?(c(),V(w,{key:0},[p(f,{style:{margin:"0",padding:"0","background-color":"#cccccc"}}),(c(!0),V(w,null,b(t.otheritems,(i,E)=>(c(),S(l,{key:i.name,onClick:x(O=>i.type=="fun"?A(i):L(i),["stop"])},{default:s(()=>[u(y(i.isSelected?"• ":"  ")+y(i.name),1)]),_:2},1032,["onClick"]))),128))],64)):Q("",!0)]),_:2},1024))),128)),p(l,{onClick:a[0]||(a[0]=t=>m(e).moveCrosshairInVox(-1,0,0)),key:"left"},{default:s(()=>[u(" 左移 ")]),_:1}),p(l,{onClick:a[1]||(a[1]=t=>m(e).moveCrosshairInVox(1,0,0)),key:"right"},{default:s(()=>[u(" 右移 ")]),_:1}),p(l,{onClick:a[2]||(a[2]=t=>m(e).moveCrosshairInVox(0,1,0)),key:"anterior"},{default:s(()=>[u(" 前移 ")]),_:1}),p(l,{onClick:a[3]||(a[3]=t=>m(e).moveCrosshairInVox(0,-1,0)),key:"posterior"},{default:s(()=>[u(" 后移 ")]),_:1}),p(l,{onClick:a[4]||(a[4]=t=>m(e).moveCrosshairInVox(0,0,1)),key:"superior"},{default:s(()=>[u(" 上移 ")]),_:1}),p(l,{onClick:a[5]||(a[5]=t=>m(e).moveCrosshairInVox(0,0,-1)),key:"inferior"},{default:s(()=>[u(" 下移 ")]),_:1})]),_:1}),te,ie]),_:1}),p(C,null,{default:s(()=>[p(v,{style:{height:"99.3vh","box-sizing":"border-box","overflow-y":"hidden"}},{default:s(()=>[re]),_:1})]),_:1})]),_:1})}}},Me=H(pe,[["__scopeId","data-v-964a987e"]]);export{Me as default};
