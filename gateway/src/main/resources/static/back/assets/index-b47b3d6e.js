import"./default-d6449ec9.js";import{_ as E,a as H}from"./index-8be33a14.js";import{C as J}from"./index-598778fa.js";import{F as Q,_ as W,M as X}from"./index-f293e05a.js";import{B as Y}from"./index-b8dcc177.js";import{R as c,_ as I,a as R,b as Z,S as ee,c as te}from"./index-f77292cd.js";/* empty css              */import{a as i,A as oe,o as ne,ac as F,ad as U,a2 as le,d as y,h as b,f as t,w as o,k as d,q as s,j as S,t as C,F as L,ae as se,_ as ae,e as ie}from"./index-1e170dd9.js";import"./index-4605ba5e.js";import{_ as de}from"./index-f13b2e24.js";import{a as ue}from"./icon-d0fda4a2.js";import"./index-86263c2f.js";import"./responsiveObserve-32929795.js";import"./collapseMotion-aa2d52e7.js";import"./Menu-7d70b547.js";import"./index-6780caaa.js";import"./Dropdown-ad434ecf.js";import"./_flatRest-684801fb.js";import"./omit-f0e2af22.js";import"./List-e1ba37cc.js";import"./eagerComputed-6d64a5a5.js";import"./debounce-0dca6d6d.js";import"./FormItemContext-4dbce140.js";import"./CheckOutlined-f559be9b.js";import"./EyeOutlined-b9fb840d.js";import"./toInteger-020d1e08.js";import"./useSize-f4b45b31.js";import"./index-e6fd304e.js";c.Group=I;c.Button=R;c.install=function(f){return f.component(c.name,c),f.component(c.Group.name,c.Group),f.component(c.Button.name,c.Button),f};const _e=s("h2",null," 导入医疗文件 ",-1),re={key:0,style:{height:"60vh",overflow:"auto"}},ce=s("h4",null,"1.分割状态",-1),pe=s("br",null,null,-1),me=s("br",null,null,-1),fe=s("h4",{style:{"margin-top":"20px"}},"3.上传到",-1),ve=s("br",null,null,-1),ge=s("br",null,null,-1),he={style:{color:"red"}},ye={key:1,style:{height:"60vh",overflow:"auto"}},xe=s("br",null,null,-1),be={style:{color:"red"}},ke={__name:"ImportFile",setup(f){const g=i("b"),v=i(!1),u=i([]),_=i([]),p=i([]),w=i([]),K=i(null),M=i(null);oe(u,()=>{console.log("selectedKeys",u.value[0])}),ne(()=>{F({user_token:h},0).then(n=>{n.code==="200"?m.value=[...n.data]:console.log(n)}),U({user_token:h},0).then(n=>{n.code==="200"?(console.log(n.data),x.value=[...n.data]):console.log(n.msg)})});const z=i([]),k=i("segmented"),m=i([]),x=i([]),T=i(""),$={title:"directoryName",key:"directoryId",user_id:0,fileLink:null},h=le().user_token,G=n=>new Promise(e=>{console.log("length:",m.value.length);const l=m.value.length===0?0:n.dataRef.directoryId||0;console.log(l),F({user_token:h},l).then(r=>{r.code==="200"?(n.dataRef.children=r.data,m.value=[...m.value],e()):(console.log("获取根目录下子目录失败"),e())})}),N=n=>new Promise(e=>{console.log("length:",m.value.length);const l=m.value.length===0?0:n.dataRef.directoryId||0;console.log(l),U({user_token:h},l).then(r=>{r.code==="200"?(console.log(r.data),n.dataRef.children=r.data,x.value=[...x.value],e()):(console.log(r.msg),e())})}),O=n=>{const e=new FormData;e.append("father_dirctory_id",u.value[0]||0),e.append("medical_status",k.value),e.append("medical_file",n.file),e.append("medical_model",T.value),console.log(e),se({user_token:h},e).then(l=>{console.log("上传文件响应值：",l),l.code==="200"?(console.log("上传成功"),v.value=!1,window.open(`http://127.0.0.1:3300/#/nii_display/0/${l.data}`,"_blank","noreferrer")):(K.value="上传失败",console.log(l.msg))})},V=()=>{window.open(`http://127.0.0.1:3300/#/nii_display/${p.value[0]}/0`,"_blank","noreferrer")},q=n=>{v.value=!1},A=n=>{console.log(n),v.value=!1};return(n,e)=>{const l=R,r=I,B=W,D=Y,P=Z,j=X;return y(),b(L,null,[t(r,{value:g.value,"onUpdate:value":e[0]||(e[0]=a=>g.value=a),"button-style":"solid"},{default:o(()=>[t(l,{value:"a"},{default:o(()=>[d("本地文件")]),_:1}),t(l,{value:"b"},{default:o(()=>[d("云端文件")]),_:1})]),_:1},8,["value"]),s("div",{class:"import_box",onClick:e[7]||(e[7]=a=>v.value=!0)},[_e,t(j,{visible:v.value,title:"上传",onOk:A,onCancel:q,footer:null},{default:o(()=>[g.value=="a"?(y(),b("div",re,[ce,pe,t(r,{value:k.value,"onUpdate:value":e[1]||(e[1]=a=>k.value=a)},{default:o(()=>[t(l,{value:"segmented"},{default:o(()=>[d("分割")]),_:1}),t(l,{value:"unsegmented"},{default:o(()=>[d("未分割")]),_:1})]),_:1},8,["value"]),me,fe,ve,t(B,{expandedKeys:_.value,"onUpdate:expandedKeys":e[2]||(e[2]=a=>_.value=a),selectedKeys:u.value,"onUpdate:selectedKeys":e[3]||(e[3]=a=>u.value=a),"load-data":G,"tree-data":m.value,"field-names":$,"show-icon":!0},{icon:o(()=>[t(S(Q))]),_:1},8,["expandedKeys","selectedKeys","tree-data"]),ge,t(P,{"file-list":z.value,"max-count":1,customRequest:O,showUploadList:!1},{default:o(()=>[t(D,{type:"primary"},{default:o(()=>[d(" 选择文件 ")]),_:1})]),_:1},8,["file-list"]),s("p",he,C(K.value||null),1)])):(y(),b("div",ye,[t(B,{expandedKeys:w.value,"onUpdate:expandedKeys":e[4]||(e[4]=a=>w.value=a),selectedKeys:p.value,"onUpdate:selectedKeys":e[5]||(e[5]=a=>p.value=a),"load-data":N,"tree-data":x.value,"field-names":$},null,8,["expandedKeys","selectedKeys","tree-data"]),xe,t(D,{type:"primary",onClick:e[6]||(e[6]=a=>V())},{default:o(()=>[d(" 确定 ")]),_:1}),s("p",be,C(M.value||null),1)]))]),_:1},8,["visible"])])],64)}}},we={style:{"font-size":"20px","font-weight":"600",display:"flex","align-items":"center"}},Ke=s("h3",null,"本地文件",-1),$e=s("h3",null,"云端文件",-1),Be={__name:"FunIntro",setup(f){return(g,v)=>{const u=de,_=ee,p=te;return y(),b(L,null,[s("div",we,[t(S(ue),{type:"icon-gongneng-",style:{"font-size":"28px"}}),d("   功能介绍 ")]),t(u),Ke,t(p,{direction:"vertical",size:"small",current:4},{default:o(()=>[t(_,{title:"第一步",description:"选择上传目录",status:"finish"},{icon:o(()=>[d(" ① ")]),_:1}),t(_,{title:"第二步",description:"上传本地文件",status:"finish"},{icon:o(()=>[d(" ② ")]),_:1}),t(_,{title:"第三步",description:"开始数据展示",status:"finish"},{icon:o(()=>[d(" ③ ")]),_:1})]),_:1}),t(u),$e,t(p,{direction:"vertical",size:"small",current:4},{default:o(()=>[t(_,{title:"第一步",description:"选择云端文件",status:"finish"},{icon:o(()=>[d(" ① ")]),_:1}),t(_,{title:"第二步",description:"开始数据展示",status:"finish"},{icon:o(()=>[d(" ② ")]),_:1})]),_:1})],64)}}};const De={__name:"index",setup(f){return(g,v)=>{const u=J,_=H,p=E;return y(),ie(p,{style:{padding:"2vh 1vw","margin-right":"0","margin-left":"0",height:"91.2vh"}},{default:o(()=>[t(_,{span:19,class:"ra-box"},{default:o(()=>[t(u,{class:"box",style:{"border-radius":"8px"}},{default:o(()=>[t(ke)]),_:1})]),_:1}),t(_,{span:5},{default:o(()=>[t(u,{style:{height:"100%","border-radius":"8px"}},{default:o(()=>[t(Be)]),_:1})]),_:1})]),_:1})}}},nt=ae(De,[["__scopeId","data-v-68d4edb6"]]);export{nt as default};