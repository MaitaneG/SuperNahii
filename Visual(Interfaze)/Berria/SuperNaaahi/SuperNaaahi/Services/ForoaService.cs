using Microsoft.EntityFrameworkCore;
using SuperNaaahi.Data;
using SuperNaaahi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.Services
{
    public class ForoaService : IForoaService
    {
        private readonly SuperNaaahiDbContext _superNaaahiDbContext;

        public ForoaService(SuperNaaahiDbContext superNaaahiDbContext)
        {
            _superNaaahiDbContext = superNaaahiDbContext;
        }

        public async Task Komentatu(Foroa f)
        {
            _superNaaahiDbContext.Foroa.Add(f);
            _superNaaahiDbContext.SaveChanges();

        }
        public async Task<IList<Foroa>> KomentarioakLortu()
        {
            return await _superNaaahiDbContext.Foroa.ToListAsync();
        }
    }
}
