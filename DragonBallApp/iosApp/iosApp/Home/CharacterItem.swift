//
//  CharacterItem.swift
//  iosApp
//
//  Created by David FIGUERES FORTUNA on 29/6/25.
//

import SwiftUI
import Shared
import Kingfisher


struct CharacterItem: View {
    let item:CharacterModel // per pasar-li per parametre
    
    var body: some View {
        ZStack {
            DiamondShape ()
                .fill(Color(.backgroundSecundary))
                .frame(width: 300, height: 300)
                .overlay (DiamondShape() .stroke(Color(.backgrounTertiari), lineWidth: 9))
                .rotationEffect(Angle(degrees: 180))
            KFImage(URL(string: item.image))
                .placeholder {
                    ProgressView()
                }.resizable()
                .scaledToFit()
               .frame(maxWidth: 100, maxHeight: 150)
            
           // AsyncImage(url: URL(string: item.image))  // per mostrar imatges pero va malament
            //    .scaledToFit()
           //     .frame(maxWidth: 100, maxHeight: 150)
            
            
            VStack{
                Spacer()
                VStack{
                    Text(item.name).font(.headline)
                    Text(item.race).font(.subheadline)
                }.frame(maxWidth:.infinity).padding(8).background(RoundedRectangle(cornerRadius: 10).stroke(Color(.backgrounTertiari), lineWidth: 9).background(Color(.backgroundSecundary)))
            }
            
            
         
                
        }.padding(.horizontal,24).padding(.vertical,12)
        
        
    }
}

#Preview {
    CharacterItem(item: CharacterModel(id:1 , name:"pepe",ki:"12222", race:"Sian",
                                 gender:"Maxo", description:"dsfsdfsdfsdf",image:""))
}
